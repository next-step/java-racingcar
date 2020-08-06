package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import resource.StringResources;

import static org.assertj.core.api.Assertions.*;

public class RacingDataTest {

    @DisplayName("RacingData 생성 성공")
    @ParameterizedTest
    @CsvSource(value = {"a,b,c:3:5", "a,b:2:4", "a:1:10"},
            delimiter = ':')
    public void makeRacingDataSuccess(String names, int numberOfCars, int tryCount) {

        RacingData racingData = new RacingData(names, numberOfCars, tryCount);

        assertThat(racingData.getNames()).isEqualTo(names.split(","));
        assertThat(racingData.getNumberOfCars()).isEqualTo(numberOfCars);
        assertThat(racingData.getTryCount()).isEqualTo(tryCount);
    }

    @DisplayName("RacingData 생성 실패 - 자동차 대수와 자동차 이름 개수 불일치")
    @ParameterizedTest
    @CsvSource(value = {"a,b,c:2:5", "a,b:3:4"}, delimiter = ':')
    public void makeRacingDataFail(String names, int numberOfCars, int tryCount) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new RacingData(names, numberOfCars, tryCount))
            .withMessage(StringResources.ERR_INVALID_CAR_DATA);;
    }

    @DisplayName("RacingData 생성 실패 - 너무 긴 자동차 이름")
    @ParameterizedTest
    @CsvSource(value = {"abcdef,abcde,abcd:3:5", "aaaaaaaaaaaa,b:2:4"}, delimiter = ':')
    public void tooLongNameData(String names, int numberOfCars, int tryCount) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new RacingData(names, numberOfCars, tryCount))
            .withMessage(StringResources.ERR_LONG_NAME);
    }
}
