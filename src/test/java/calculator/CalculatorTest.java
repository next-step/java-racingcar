package calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @BeforeEach
    void setUp() {
        System.out.println("setup Calculator");
    }

    // 사칙연산 단위 테스트
    @Test
    public void addTest() {
        int result = Calculator.add(1,3);
        assertThat(result).isEqualTo(4);
    }

    @Test
    public void subtractTest() {
        int result = Calculator.subtract(1,3);
        assertThat(result).isEqualTo(-2);
    }

    @AfterEach
    public void tearDown() {
        System.out.println("tearDown");
    }


}
