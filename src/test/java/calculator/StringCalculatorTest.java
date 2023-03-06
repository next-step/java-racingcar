package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringCalculatorTest {

    StringCalculator stringCalculator;

    @BeforeEach
    public void init(){
        stringCalculator = new StringCalculator();
    }

    @Test
    @DisplayName("add test")
    void addTest(){
        int actual = stringCalculator.add(1,2);

        assertThat(actual).isEqualTo(3);
    }

    @Test
    @DisplayName("subtract test")
    void subtractTest(){
        int actual = stringCalculator.subtract(2,1);

        assertThat(actual).isEqualTo(1);
    }

    @Test
    @DisplayName("multiply test")
    void multiplyTest(){
        int actual = stringCalculator.multiply(1,2);

        assertThat(actual).isEqualTo(2);
    }

    @Test
    @DisplayName("devide test")
    void devideTest(){
        int actual = stringCalculator.devide(1,1);

        assertThat(actual).isEqualTo(1);
    }

    @Test
    @DisplayName("reg test")
    void regTest(){
        String[] actual = stringCalculator.seperate("1 + 2");

        assertThat(actual).isEqualTo(new String[]{"1", "+", "2"});

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {stringCalculator.seperate("1 m 1");});

    }

    @Test
    void calculatorTest() {

        int actual = stringCalculator.calculator("1 + 2 * 5 / 2");

        assertThat(actual).isEqualTo(7);

    }
}
