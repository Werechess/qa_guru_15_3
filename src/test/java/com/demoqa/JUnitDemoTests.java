package com.demoqa;

import org.junit.jupiter.api.*;

class JUnitDemoTests {

    @BeforeAll
    static void setUp() {
        System.out.println("### @BeforeAll !");
    }

    @AfterAll
    static void tearDown() {
        System.out.println("### @AfterAll !");
    }

    @BeforeEach
    void beforeEachTest() {
        System.out.println("###     @BeforeEach !");
    }

    @AfterEach
    void afterEachTest() {
        System.out.println("###     @AfterEach !");
    }

    @Test
    void simpleTestFirst() {
        System.out.println("###         @Test simpleTestFirst !");
        Assertions.assertTrue(2 > 1);
    }

    @Test
    void simpleTestSecond() {
        System.out.println("###         @Test simpleTestSecond !");
        Assertions.assertTrue(3 > 2);
    }
}
