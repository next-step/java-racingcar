package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StrCalculatorTest {

    StrCalculator StrCalculator;

    @BeforeEach
    public void init(){
        StrCalculator = new StrCalculator();
    }

    @Test
    @DisplayName("[01]덧셈확인")
    void addTest(){
        int actual = StrCalculator.add(1,2);

        assertThat(actual).isEqualTo(3);
    }

    @Test
    @DisplayName("[02]뺄셈확인")
    void subTest(){
        int actual = StrCalculator.sub(2,1);

        assertThat(actual).isEqualTo(1);
    }

    @Test
    @DisplayName("[03]곱셈확인")
    void mulTest(){
        int actual = StrCalculator.mul(1,2);

        assertThat(actual).isEqualTo(2);
    }

    @Test
    @DisplayName("[04]나눗셈확인")
    void divTest(){
        int actual = StrCalculator.div(1,1);

        assertThat(actual).isEqualTo(1);
    }

    @Test
    @DisplayName("[05] strSeperateTest")
    void strSeparateTest(){
        String[] actual = StrCalculator.seperate("1 + 2");

        assertThat(actual).isEqualTo(new String[]{"1", "+", "2"});

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {StrCalculator.seperate("1 m 1");});

    }

    @Test
    @DisplayName("[06] calculatorTest")
    void calculatorTest() {

        int actual = StrCalculator.calculator("1 + 2 * 5 / 2");

        assertThat(actual).isEqualTo(7);

    }
}