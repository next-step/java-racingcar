package step4.dto.name;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step4.dto.count.Count;

import java.util.Arrays;
import java.util.List;

class CarNameGroupTest {

    @ParameterizedTest
    @CsvSource(value = {"aa,bb,cc|3", "aa,bb|2", "aa|1"}, delimiter = '|')
    @DisplayName("자동차 이름을 넣은 갯수만큼 반환한다")
    public void carNameLengthTest(String carName, int expected) {
        List<String> carNames = Arrays.asList(carName.split(","));

        Assertions.assertThat(new CarNameGroup(carNames).carNameLength()).isEqualTo(new Count(expected));
    }
}
