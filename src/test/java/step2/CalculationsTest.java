package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculationsTest {

    @DisplayName("덧셈 테스트")
    @ParameterizedTest
    @ValueSource(strings ={"2 + 3 + 7"})
    void plusTest(String value){
        String[] result = value.split(" ");
        assertThat(calc(result)).isEqualTo(12);

    }

    @DisplayName("뺄셈 테스트")
    @ParameterizedTest
    @ValueSource(strings ={"2 - 3"})
    void minusTest(String value){
        String[] result = value.split(" ");
        assertThat(calc(result)).isEqualTo(-1);
    }

    @DisplayName("곱셈 테스트")
    @ParameterizedTest
    @ValueSource(strings ={"2 * 3"})
    void multiplyTest(String value){
        String[] result = value.split(" ");
        assertThat(calc(result)).isEqualTo(6);
    }

    @DisplayName("나눗셈 테스트")
    @ParameterizedTest
    @ValueSource(strings ={"10 / 3"})
    void divideTest(String value){
        String[] result = value.split(" ");
        assertThat(calc(result)).isEqualTo(3);
    }

    @DisplayName("사칙 연산을 모두 포함하는 기능 구현")
    @ParameterizedTest
    @ValueSource(strings ={"10 + 20 * 30 / 10"})
    void allTest(String value){
        String[] result = value.split(" ");
        assertThat(calc(result)).isEqualTo(90);
    }

    @DisplayName("존재하지 않는 연산자 IllegalArgumentException")
    @ParameterizedTest
    @ValueSource(strings ={"2 3"})
    void illegalArgumentException(String value){
        String[] result = value.split(" ");
        assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() ->{
            assertThat(calc(result));
        });
    }

    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw")
    @ParameterizedTest
    @ValueSource(strings ={" + 3"})
    void nullValueException(String value){
        String[] result = value.split(" ");
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() ->{
                assertThat(calc(result));
            });
    }

    public int calc(String[] test){
        int result = Operator.of(test[1]).calculate(Integer.parseInt(test[0]), Integer.parseInt(test[2]));
        for (int i = 3; i < test.length; i +=2){
            result = Operator.of(test[i]).calculate(result, Integer.parseInt(test[i+1]));
        }
        return result;
    }
}
