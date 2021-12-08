package fr.lernejo.tester.internal;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TestClassDiscoverer {
    private final String packageName;

    public TestClassDiscoverer(String packageName) {
        this.packageName = packageName;
    }

    public List<TestClassDescription> listTestClasses() {
        Reflections reflections = new Reflections(packageName, new SubTypesScanner(false));
        Set<Class<?>> allTypes = reflections.getSubTypesOf(Object.class);

        LinkedList<TestClassDescription> list = new LinkedList<>();

        for (Class<?> c: allTypes) {
            if (c.getName().endsWith("LernejoTests")) {
                list.add(new TestClassDescription(c));
            }
        }

        return list;
    }
}