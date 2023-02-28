package test;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // Test Case 구현
}


public class LifecycleTest {
    @BeforeAll
    static void initAll() {
        System.out.println("initAll");
    }

    @BeforeEach
    void init() {
        System.out.println("init");
    }

    @Test
    void someTest() {
        System.out.println("someTest");
    }

    @Test
    void anyTest() {
        System.out.println("anyTest");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("tearDownAll");
    }
}