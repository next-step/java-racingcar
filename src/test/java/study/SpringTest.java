package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-13 21:12
 */
public class SpringTest {


    /**
     * test method는 순서에 맞게 수행되는 것이 아님.
     *      random으로 method가 수행된다.
     *
     *
     * Life Cycle
     * {
     *      setup
     *      split1
     *      tearDown
     *      setup
     *      split2
     *      tearDown
     *      setup
     *      tearDown
     * }
     */

    @Test
    void split() {
        String[] result = "1,2".split(",");
//        System.out.println(result); // 옛날의 main method 테스트 방식

        assertThat(result[0]).isEqualTo("1");
        assertThat(result[1]).isEqualTo("2");

        assertThat(result).contains("3");   // Index를 굳이 사용하지 않아도 contains로 확인도 가능

        assertThat(result).containsExactly("1", "2");   // 1,2의 순서까지 보장

    }

    @BeforeEach
    void setUp() {
        System.out.println("setup");
    }

    @Test
    void split1() {
        System.out.println("split1");
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");   // 1,2의 순서까지 보장

    }
    @Test
    void split2() {
        System.out.println("split2");
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");   // 1,2의 순서까지 보장

    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown");
    }
}
