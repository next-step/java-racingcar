package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.value.CarName;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarNameTest {

    @ParameterizedTest
    @DisplayName("정상적으로 생성 되는지 검증")
    @ValueSource(strings = {"lee","kim"})
    void createTest(String carName) {
        CarName car = CarName.create(carName);

        assertThat(car).isEqualTo(CarName.create(carName));
    }

    @ParameterizedTest
    @DisplayName("5글자가 넘을 때 에러 발생 검증")
    @ValueSource(strings = {"leejeonggi","kimjunggun"})
    void createErrorTest(String carName) {
        assertThatIllegalArgumentException().isThrownBy(() -> CarName.create(carName));
    }
}
