package racingcar.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CountInfoTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3})
    @DisplayName("0 미만의 값으로 객체를 생성할 때 예외 발생")
    void underZeroCountExceptionTest(int count){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new CountInfo(count))
                .withMessage("입력 값은 0보다 커야합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("0 이상의 값들로 객체를 생성할 때 정상적으로 객체 생성")
    void validCountTest(int count){
        CountInfo countInfo = new CountInfo(count);
        assertThat(countInfo.get()).isEqualTo(count);
    }
}