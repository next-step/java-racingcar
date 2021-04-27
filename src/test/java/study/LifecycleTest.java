package study;

import org.junit.jupiter.api.*;

public class LifecycleTest {
    @BeforeAll
    static void initAll() {
        System.out.println("initAll"); //시작하기 전에 실행
//        해당 annotation 이 달린 메서드가 현재 클래스의 모든 테스트 메서드보다 먼저 실행된다.
    }

    @BeforeEach
    void init() {
        System.out.println("init");
//        해당 annotation 이 달린 메서드가 각 테스트 메서드 전에 실행된다.

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
