package fr.lernejo.tester.internal;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.lang.model.element.Element;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TestClassDiscovererLernejoTests {
    @Test
    public void get_class() {
        TestClassDiscoverer classDiscoverer = new TestClassDiscoverer("fr.lernejo.tester");
        List<TestClassDescription> classDescription = classDiscoverer.listTestClasses();

        Assertions.assertThat((int) classDescription.size())
            .isEqualTo(3);
    }
}