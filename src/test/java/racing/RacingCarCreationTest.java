package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;


class RacingCarCreationTest {

    @DisplayName("단일 자동차 객체 생성")
    @ParameterizedTest(name = "자동차 이름: {0}")
    @ValueSource(strings = {"Car1", "LongCarName", "C"})
    void singleCarCreation(String carName) {
        MoveStrategy dummyStrategy = () -> false;
        RacingCar racingCar = new RacingCar(carName, dummyStrategy);

        assertThat(racingCar)
                .isExactlyInstanceOf(RacingCar.class)
                .satisfies(car -> {
                    assertThat(car.getPosition()).isZero();
                    assertThat(car.getName()).isEqualTo(carName);
                });
    }

    @DisplayName("여러 대의 자동차 객체 생성")
    @Test
    void multipleCarCreation() {
        MoveStrategy dummyStrategy = () -> false;
        RacingCar racingCar1 = new RacingCar("Car1", dummyStrategy);
        RacingCar racingCar2 = new RacingCar("Car2", dummyStrategy);

        assertThat(racingCar1)
                .isNotSameAs(racingCar2)
                .satisfies(car -> {
                    assertThat(car.getName()).isEqualTo("Car1");
                    assertThat(car.getPosition()).isZero();
                });

        assertThat(racingCar2)
                .satisfies(car -> {
                    assertThat(car.getName()).isEqualTo("Car2");
                    assertThat(car.getPosition()).isZero();
                });
    }

}
