package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racing.model.Cars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarsTest {

    @ParameterizedTest
    @ValueSource(strings = {"javajigi, cwpark, ironman, cwpark"})
    @DisplayName("이름 중복 입력 시 테스트")
    void isDuplicationTest(String inputCarNames) {
        Cars cars = new Cars();
        assertThatIllegalArgumentException().isThrownBy(() -> cars.isDuplication(inputCarNames));
    }

    @ParameterizedTest
    @ValueSource(strings = {"javajigi, cwpark, ironman"})
    @DisplayName("자동차 생성 테스트")
    void createCarsTest(String inputCarNames) {
        Cars cars = new Cars();
        assertThat(cars.createCars(inputCarNames)).isEqualTo(new Cars().createCars("javajigi, cwpark, ironman"));
    }

    @ParameterizedTest
    @CsvSource(value = {"javajigi, cwpark, ironman:3"}, delimiter = ':')
    @DisplayName("자동차 대수 확인 테스트")
    void countOfCarsTest(String inputCarNames, int countOfCars) {
        Cars cars = new Cars();
        assertThat(cars.createCars(inputCarNames).countOfCars()).isEqualTo(countOfCars);
    }
}