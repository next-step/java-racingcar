package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import race.domain.CarName;
import race.domain.CarNames;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarNamesTest {

    @DisplayName("입력받은 문자열을 구분자로 잘 구분하여 자동차 이름을 생성하는지 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"a,b,c:,", "a/:/"}, delimiter = ':')
    void createWithDelimiterTest(String names, String delimiter) {
        CarNames carNames = CarNames.createWithDelimiter(names, delimiter);

        String[] split = names.split(delimiter);
        assertThat(split).hasSize(carNames.size());

        IntStream.range(0, split.length).forEach(index -> {
            CarName carName = carNames.get(index);
            assertThat(carName.get()).isEqualTo(split[index]);
        });
    }
}
