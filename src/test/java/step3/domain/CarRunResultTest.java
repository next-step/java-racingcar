package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarRunResultTest {

    @ParameterizedTest
    @CsvSource(value = {"car1,1", "car2,5", "car3,10"}, delimiter = ',')
    @DisplayName("경주차가 이동한 거리수만큼 주행결과는 '-'문자를 갖는다.")
    void name(String carName, int runDistance) {
        CarRunResult result = new CarRunResult(carName, runDistance);

        String runReultString = result.generateCarRunResultString();
        long symbolCount = countCharInString(runReultString, CarRunResult.PROGRESS_SYMBOL);
        assertThat(symbolCount).isEqualTo(runDistance);
    }


    private long countCharInString(String string, char c) {

        long count = string.chars().filter(ch -> ch == c).count();

        return count;
    }
}