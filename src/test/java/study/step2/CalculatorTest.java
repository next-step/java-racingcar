package study.step2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {

//    1)
    Calculator calculator = new Calculator();

//    2)
//    static Calculator calculator;
//    @BeforeAll
//    static void setup(){
//        calculator = new Calculator();
//    }

//    3)
//    Calculator calculator = new Calculator();
//    @BeforeEach
//    void setup(){
//        calculator = new Calculator();
//    }

    @Test
    @DisplayName("덧셈")
    void plus(){
        assertThat(calculator.operation("3", "+","5")).isEqualTo(8);
    }

    @Test
    @DisplayName("뺄셈")
    void minus(){
        assertThat(calculator.operation("5","-", "3")).isEqualTo(2);
    }

    @Test
    @DisplayName("곱셈")
    void multiply(){
        assertThat(calculator.operation("3","*", "5")).isEqualTo(15);
    }

    @Test
    @DisplayName("나눗셈")
    void divide(){

        assertThat(calculator.operation("5","/", "3")).isEqualTo(1);
        assertThat(calculator.operation("6","/", "3")).isEqualTo(2);
        assertThat(calculator.operation("8","/", "5")).isEqualTo(1);
        assertThat(calculator.operation("125","/", "7")).isEqualTo(17);

    }

    @Test
    @DisplayName("잘못된 값 입력 시 IllegalArgumentException 발생")
    void exception(){

        assertThatIllegalArgumentException().isThrownBy( () -> { calculator.calculator(null); });
        assertThatIllegalArgumentException().isThrownBy( () -> { calculator.calculator(""); });
        assertThatIllegalArgumentException().isThrownBy( () -> { calculator.calculator("3 ^ 5 & 8"); });
        assertThatIllegalArgumentException().isThrownBy( () -> { calculator.calculator("3 / 0"); });
        assertThatIllegalArgumentException().isThrownBy( () -> { calculator.calculator("3 * 0 * 100 + 100 /"); });
        assertThatIllegalArgumentException().isThrownBy( () -> { calculator.calculator("3 - --1"); });
        assertThatIllegalArgumentException().isThrownBy( () -> { calculator.calculator("3 - ++1"); });

    }

    @Test
    @DisplayName("계산기 정상 동작")
    void calculator(){
        assertThat(calculator.calculator("2 + 3 * 4 / 2")).isEqualTo(10);
        assertThat(calculator.calculator("2 + 3 - 4 - 2")).isEqualTo(-1);
        assertThat(calculator.calculator("2 * 3 * 4 / 2 * 100 - 2")).isEqualTo(1198);
        assertThat(calculator.calculator("100 * 3 * 4 - 50 / 2 * 100 - 2")).isEqualTo(57498);
        assertThat(calculator.calculator("1 - -1")).isEqualTo(2);
        assertThat(calculator.calculator("1 - +1")).isEqualTo(0);
        assertThat(calculator.calculator("999999999 - +1")).isEqualTo(999999998);
    }
}

