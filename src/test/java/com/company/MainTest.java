package com.company;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    public static double[] nums = new double[] {76.66666666666666, 81.66666666666666, 70.0};

    @org.junit.jupiter.api.Test
    void min() {
        var main = new Main();
        assertEquals("70.0!", main.min(nums, 4));
    }

    @org.junit.jupiter.api.Test
    void max() {
        var main = new Main();
        assertEquals("81.66666666666666!", main.max(nums, 4));
    }
}