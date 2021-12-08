package fr.lernejo.tester.internal;
import fr.lernejo.tester.SomeLernejoTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

class TestClassDescriptionLernejoTests {
    public TestClassDescriptionLernejoTests() {

    }

    @Test
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
        Assertions.assertLinesMatch(expectedLines, resultLines);
    }
    public static void main(String[] args) {
        TestClassDescriptionLernejoTests tests = new TestClassDescriptionLernejoTests();
        tests.get_methods();
    }
}