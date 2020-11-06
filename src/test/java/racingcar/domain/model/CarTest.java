package racingcar.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import racingcar.asset.CarConst;
import racingcar.domain.strategy.MoveStrategy;
import racingcar.domain.strategy.ProceedStrategy;
import racingcar.domain.strategy.StopStrategy;
import racingcar.exeption.BadCarNameException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CarTest {

    @ParameterizedTest
    @DisplayName("createCar: name 이 최대 길이를 초과하면, BadCarNameException 가 발생된다.")
    @ValueSource(strings = {"", "1", "22", "333", "4444", "55555", "666666", "7777777", "88888888"})
    void createCar(String name) {
        MoveStrategy strategy = Mockito.mock(MoveStrategy.class);
        if (name.length() <= CarConst.MAX_NAME_LENGTH) {
            Assertions.assertDoesNotThrow(() -> {
                Car.createCar(name, strategy);
            });
            return;
        }
        assertThatExceptionOfType(BadCarNameException.class)
                .isThrownBy(() -> {
                    Car.createCar(name, strategy);
                }).withMessageMatching(CarConst.MAX_NAME_LENGTH_EXCEEDED);
    }

    @Test
    @DisplayName("createCar: name 이 null 이면, 에러가 발생된다.")
    void createCar() {
        MoveStrategy strategy = Mockito.mock(MoveStrategy.class);
        assertThatExceptionOfType(BadCarNameException.class)
                .isThrownBy(() -> {
                    Car.createCar(null, strategy);
                }).withMessageMatching(CarConst.NULL_NAME_ERR);
    }

    @ParameterizedTest
    @DisplayName("validateName: name 이 최대 길이를 초과하면, BadCarNameException 가 발생한다.")
    @ValueSource(strings = {"", "1", "22", "333", "4444", "55555", "666666", "7777777", "88888888"})
    void validateName(String name) {
        if (name.length() <= CarConst.MAX_NAME_LENGTH) {
            Assertions.assertDoesNotThrow(() -> {
                Car.validateName(name);
            });
            return;
        }
        assertThatExceptionOfType(BadCarNameException.class)
                .isThrownBy(() -> {
                    Car.validateName(name);
                }).withMessageMatching(CarConst.MAX_NAME_LENGTH_EXCEEDED);
    }

    @Test
    @DisplayName("validateName: name 이 null 이면, 에러가 발생된다.")
    void validateName() {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> {
                    validateName(null);
                });
    }

    @ParameterizedTest
    @DisplayName("clone 의 이름과 position 이 같아야 한다.")
    @CsvSource(value = {"a:1", "b:2", "c:3", "d:4", "e:5", "f:6", "g:7"}, delimiter = ':')
    void testClone(String name, int position) {
        MoveStrategy strategy = ProceedStrategy.getInstance();
        Car car = Car.createCar(name, strategy);
        for (int i = 0; i < position; i++) {
            car.move();
        }
        Car clonedCar = car.clone();
        Assertions.assertAll(
                () -> {
                    assertThat(clonedCar.getName())
                            .isEqualTo(car.getName());
                },
                () -> {
                    assertThat(clonedCar.getPosition())
                            .isEqualTo(car.getPosition());
                }
        );
    }

    @Test
    @DisplayName("movable 인 경우만 전진해야 한다.")
    void move() {
        MoveStrategy proceedStrategy = ProceedStrategy.getInstance();
        String movableName = "move";
        Car movableCar = Car.createCar(movableName, proceedStrategy);

        MoveStrategy stopStrategy = StopStrategy.getInstance();
        String stoppedName = "stop";
        Car stoppedCar = Car.createCar(stoppedName, stopStrategy);

        movableCar.move();
        stoppedCar.move();

        int movedPosition = 2;
        int stoppedPosition = 1;
        Assertions.assertAll(
                () -> {
                    assertThat(movableCar.getPosition())
                            .isEqualTo(movedPosition);
                },
                () -> {
                    assertThat(stoppedCar.getPosition())
                            .isEqualTo(stoppedPosition);
                }
        );
    }

    @Test
    @DisplayName("strategy 가 stop 으로 바뀌면 전진하지 않는.")
    void setStrategy() {
        String name = "car";
        MoveStrategy proceedStrategy = ProceedStrategy.getInstance();
        MoveStrategy stopStrategy = StopStrategy.getInstance();

        Car car = Car.createCar(name, proceedStrategy);
        int expectedPosition = 2;
        car.move();
        assertThat(car.getPosition())
                .isEqualTo(expectedPosition);

        car.setStrategy(stopStrategy);
        car.move();
        assertThat(car.getPosition())
                .isEqualTo(expectedPosition);
    }
}
