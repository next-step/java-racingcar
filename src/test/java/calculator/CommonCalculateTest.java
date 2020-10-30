package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * 계산기 단위테스트
 */
public class CommonCalculateTest {

    @ParameterizedTest(name = "{index} => a={0}, b={1}, resultType={2}")
    @CsvSource({
            "2, 2, 0",
            "4, 2, 2",
            "2, 1, 1"
    })
    @DisplayName("뺄셈")
    void subCalculateTest( int a,  int b,  int resultType){
        assertThat(CommonCalculate.subCalculate(a , b)).isEqualTo(resultType);
    }

    @ParameterizedTest(name = "{index} => a={0}, b={1}, resultType={2}")
    @CsvSource({
            "2, 2, 4",
            "4, 2, 8",
            "2, 1, 2"
    })
    @DisplayName("곱하기")
    void mulCalculateTest( int a,  int b,  int resultType){
        assertThat(CommonCalculate.mulCalculate(a , b)).isEqualTo(resultType);
    }

    @ParameterizedTest(name = "{index} => a={0}, b={1}, resultType={2}")
    @CsvSource({
            "2, 2, 1",
            "4, 2, 2",
            "2, 1, 2"
    })
    @DisplayName("나눗셈")
    void divCalculateTest( int a,  int b,  int resultType){
        assertThat(CommonCalculate.divCalculate(a , b)).isEqualTo(resultType);
    }

    @ParameterizedTest(name = "{index} => a={0}, b={1}, resultType={2}")
    @CsvSource({
            "2, 2, 4",
            "4, 2, 6",
            "2, 1, 3"
    })
    @DisplayName("덧셈")
    void addCalculateTest( int a,  int b,  int resultType){
        assertThat(CommonCalculate.addCalculate(a , b)).isEqualTo(resultType);
    }
}
