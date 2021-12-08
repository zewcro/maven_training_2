package fr.lernejo.tester.internal;

import fr.lernejo.tester.api.TestMethod;

import java.util.List;

public class TestClassDiscovererLernejoTests {

    @TestMethod
    public void get_class() {
        TestClassDiscoverer classDiscoverer = new TestClassDiscoverer("fr.lernejo.tester");
        List<TestClassDescription> classDescription = classDiscoverer.listTestClasses();
        if (classDescription.size() == 3) return;
        throw new RuntimeException();
    }
}