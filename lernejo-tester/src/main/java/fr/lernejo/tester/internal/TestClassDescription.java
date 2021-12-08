package fr.lernejo.tester.internal;
import fr.lernejo.tester.api.TestMethod;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;

public class TestClassDescription {
    public final Class<?> classToTest;

    public TestClassDescription(Class<?> classToTest) {
        this.classToTest = classToTest;
    }
    public List<Method> listTestMethods() {
        Method[] allMethods = classToTest.getDeclaredMethods();
        LinkedList<Method> returnMethods = new LinkedList<>();
        for (Method m: allMethods) {
            String returnParam = m.getReturnType().getName();
            if (Modifier.isPublic(m.getModifiers()) &&
                returnParam.equals("void") &&
                m.isAnnotationPresent(TestMethod.class) &&
                m.getParameterCount() == 0) {
                    returnMethods.add(m);
            }
        }

        return returnMethods;
    }

    @Override
    public String toString() {
        return "TestClassDescription { " +
            "classToTest = " + classToTest +
            " }";
    }
}