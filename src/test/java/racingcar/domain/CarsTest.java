package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @DisplayName("입력된 차 이름목록이 Null, empty, 공백, 길이 5자 초과 차 이름을 포함할 시 IllegalArgumentExcpetion 발생")
    @ParameterizedTest(name = "{index} {displayName} {arguments}")
    @NullAndEmptySource
    @ValueSource(strings = {"  ", "benz,porsche"})
    void create_ThrowsIllegalArgumentException_IfCarNamesIsNullOrEmptyOrBlankOrInvolveCarNameLengthMoreThanFive(String carNames) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(
                () -> new Cars(carNames));
    }

    @DisplayName("생성")
    @Test
    void create() {
        String carNames = "benz,bmw,audi";
        Cars cars = new Cars(carNames);
        assertThat(cars.getCars().size()).isEqualTo(carNames.split(",").length);
    }

    @DisplayName("이동")
    @Test
    void moveCars_PositionIsOne() {
        String carNames = "benz,bmw,audi";
        Cars cars = new Cars(carNames);
        cars.moveCars(() -> true);

        for (Car car : cars.getCars()) {
            assertThat(car.getPosition()).isEqualTo(new Position(1));
        }
    }
}
