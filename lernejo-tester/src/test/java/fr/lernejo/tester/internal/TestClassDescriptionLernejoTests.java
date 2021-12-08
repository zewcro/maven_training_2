package fr.lernejo.tester.internal;

import fr.lernejo.tester.SomeLernejoTests;
import fr.lernejo.tester.api.TestMethod;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

class TestClassDescriptionLernejoTests {

    @TestMethod
    public void get_methods() {
        Class<SomeLernejoTests> classToTest = SomeLernejoTests.class;
        TestClassDescription tester = new TestClassDescription(classToTest);
        List<Method> allMethods = tester.listTestMethods();

        List<String> expectedLines = new LinkedList<>();
        expectedLines.add("ok");
        expectedLines.add("ko");

        List<String> resultLines = new LinkedList<>();
        for (Method m: allMethods) {
            resultLines.add(m.getName());
        }

        if (resultLines.get(0).equals(expectedLines.get(0)) && resultLines.get(1).equals(expectedLines.get(1))) return;
        throw new RuntimeException();
    }
}