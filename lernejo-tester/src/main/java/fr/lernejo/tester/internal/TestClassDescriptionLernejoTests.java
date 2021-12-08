package fr.lernejo.tester.internal;

import fr.lernejo.tester.SomeLernejoTests;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestClassDescriptionLernejoTests {
    @Test
    public void get_methods() {
        Class<SomeLernejoTests> classToTest = SomeLernejoTests.class;
        TestClassDescription tester = new TestClassDescription(classToTest);
        List<Method> allMethods = tester.listTestMethods();

        System.out.println(Arrays.toString(allMethods.toArray()));
    }

    public static void main(String[] args) {
        TestClassDescriptionLernejoTests tests = new TestClassDescriptionLernejoTests();

        tests.get_methods();
    }
}