package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsGeneratorTest {

    @Test
    @DisplayName("쉼표로 구분한 자동차 이름으로 자동차를 생성한다")
    void generateCars() {
        String carNames = "pobi,crong,honux";
        Cars cars = CarsGenerator.generateCars(carNames);
        cars.getCarsNameAndPosition().forEach((nameAndPosition) -> {
            String name = nameAndPosition.getFirst().getValue();
            Assertions.assertThat(name).isIn("pobi", "crong", "honux");
        });
    }
}
