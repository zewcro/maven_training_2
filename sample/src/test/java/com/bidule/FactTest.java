package com.bidule;
import fr.lernejo.tester.api.TestMethod;
class FactTest {
    @TestMethod
    public void fact_negative_num() {
        Fact test = new Fact();

        try {
            test.fact(-1);
        } catch (IllegalArgumentException e) {
            // ok
            return;
        }

        throw new RuntimeException();
    }

    @TestMethod
    public void fact_positive_num() {
        Fact test = new Fact();
        int result = test.fact(3);

        if (result == 6) return;
        throw new RuntimeException();
    }
}