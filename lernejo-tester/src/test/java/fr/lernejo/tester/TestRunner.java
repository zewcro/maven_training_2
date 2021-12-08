package fr.lernejo.tester;

import fr.lernejo.tester.internal.TestClassDescription;
import fr.lernejo.tester.internal.TestClassDiscoverer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestRunner {

    public static void main(String[] args) {
        int totalDone = 0;
        int totalFail = 0;
        boolean fail;

        long allBegin = System.currentTimeMillis();
        for (String packages: args) {
            TestClassDiscoverer classDiscoverer = new TestClassDiscoverer(packages);
            List<TestClassDescription> classDescription = classDiscoverer.listTestClasses();

            for (TestClassDescription testClass: classDescription) {
                try {
                    Constructor<?> constructor = testClass.classToTest.getConstructor();
                    constructor.setAccessible(true);
                    Object testInstance = constructor.newInstance();
                    List<Method> methods = testClass.listTestMethods();

                    for (Method m : methods) {
                        long methodBegin = 0;
                        long methodEnd = 0;
                        try {
                            methodBegin = System.currentTimeMillis();
                            m.invoke(testInstance);
                            fail = false;
                            totalDone++;
                        } catch (Exception e) {
                            fail = true;
                            totalFail++;
                        } finally {
                            methodEnd = System.currentTimeMillis();
                        }

                        long methodFinal = methodEnd - methodBegin;
                        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS");
                        Date resultTime = new Date(methodFinal);

                        System.out.println(testClass.classToTest.toString() + "#" + m.getName()
                            + "    " + (fail ? "KO" : "OK") + "    " + sdf.format(resultTime));
                    }
                } catch (Exception e) {
                    System.out.println("Error while testing " + testClass.classToTest.toString());
                }
            }
        }
        long allEnd = System.currentTimeMillis();

        long allFinal = allEnd - allBegin;
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS");
        Date resultTime = new Date(allFinal);

        System.out.println("\nTests executed: " + (totalDone + totalFail) + "\n"
            + "    Tests done: " + totalDone + "\n"
            + "    Tests failed : " + totalFail + "\n"
            + "Total execution time: " + sdf.format(resultTime));
    }
}