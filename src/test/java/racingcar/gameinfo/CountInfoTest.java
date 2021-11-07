package racingcar.gameinfo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CountInfoTest {

    @ParameterizedTest
    @CsvSource(value = {"-1,1", "1,-1", "-1,-1"})
    @DisplayName("0 미만의 값으로 객체를 생성할 때 예외 발생")
    void underZeroCountExceptionTest(int carCount, int tryCount){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new CountInfo(carCount, tryCount))
                .withMessage("입력 값은 0보다 커야합니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"0,0", "1,2", "2,2", "2,5"})
    @DisplayName("0 이상의 값들로 객체를 생성할 때 정상적으로 객체 생성")
    void validCountTest(int carCount, int tryCount){
        CountInfo countInfo = new CountInfo(carCount, tryCount);
        assertThat(countInfo.getCarCount()).isEqualTo(carCount);
        assertThat(countInfo.getTryCount()).isEqualTo(tryCount);
    }
}
