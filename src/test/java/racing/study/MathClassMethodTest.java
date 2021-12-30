package racing.study;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MathClassMethodTest {

    private static final int MAX_NUMBER = 100;
    private static final int MIN_NUMBER = 0;

    @Test
    @DisplayName("Math클래스의 round 메소드 (소숫점 첫째 자리에서 반올림) 테스트")
    void math_round() {
        double plusRoundUp = 5.63;
        double plusRoundDown = 5.42;
        double minusRoundUp = -5.68;
        double minusRoundDown = -5.33;

        assertEquals(Math.round(plusRoundUp), 6);
        assertEquals(Math.round(plusRoundDown), 5);
        assertEquals(Math.round(minusRoundUp), -6);
        assertEquals(Math.round(minusRoundDown), -5);
    }

    @Test
    @DisplayName("Math클래스의 abs 메소드(절대값 반환) 테스트")
    void math_abs() {
        double plus = 5.67;
        double minus = -5.33;

        assertEquals(Math.abs(plus), 5.67);
        assertEquals(Math.abs(minus), 5.33);
    }

    @Test
    @DisplayName("Math클래스의 ceil 메소드 (소숫점 첫째 자리에서 올림) 테스트")
    void math_ceil() {
        double plus = 5.2888;
        double minus = -5.4234;

        assertEquals(Math.ceil(plus), 6.0);
        assertEquals(Math.ceil(minus), -5.0);
    }

    @Test
    @DisplayName("Math클래스의 floor 메소드 (소숫점 첫째 자리에서 내림) 테스트")
    void math_floor() {
        double plus = 5.7889;
        double minus = -5.2788;

        assertEquals(Math.floor(plus), 5.0);
        assertEquals(Math.floor(minus), -6.0);
    }

    @Test
    @DisplayName("Math클래스의 max 메소드 (두 수를 비교하여 최댓값 반환) 테스트")
    void math_max() {
        double max = 30;
        double min = -40;

        assertEquals(Math.max(min, max), max);
    }

    @Test
    @DisplayName("Math클래스의 min 메소드 (두 수를 비교하여 최솟값 반환) 테스트")
    void math_min() {
        double max = 30;
        double min = -40;

        assertEquals(Math.min(min, max), min);
    }

    @Test
    @DisplayName("Math클래스의 random 메소드 (해당 범위 내의 정수 난수 생성) 테스트")
    void math_integer_random() {
        for (int i = 0; i < 50; i++) {
            double number = (Math.random() * (MAX_NUMBER - MIN_NUMBER + 1)) + MIN_NUMBER;
            System.out.println(number);
            assertTrue((MIN_NUMBER <= number) && (number <= MAX_NUMBER));
        }
    }

    @Test
    @DisplayName("Math클래스의 random 메소드 (해당 범위 내의 실 난수 생성) 테스트")
    void math_double_random() {
        for (int i = 0; i < 50; i++) {
            int number = (int) (Math.random() * (MAX_NUMBER - MIN_NUMBER + 1)) + MIN_NUMBER;
            System.out.println(number);
            assertTrue((MIN_NUMBER <= number) && (number <= MAX_NUMBER));
        }

    }

}
