package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("Car 클래스의 테스트")
class CarTest {

    @ParameterizedTest
    @DisplayName("name 이 최대 길이를 초과하면, IllegalArgumentException 가 발생된다.")
    @ValueSource(strings = {"", "1", "22", "333", "4444", "55555", "666666", "7777777", "88888888"})
    void car(String name) {
        MoveStrategy strategy = Mockito.mock(MoveStrategy.class);
        if (name.length() <= CarConst.MAX_NAME_LENGTH) {
            Assertions.assertDoesNotThrow(() -> {
                new Car(name, strategy);
            });
            return;
        }
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Car(name, strategy);
                }).withMessageMatching(CarConst.MAX_NAME_LENGTH_EXCEEDED);
    }
    
    @Test
    @DisplayName("name 이 null 이면, 에러가 발생된다.")
    void car() {
        MoveStrategy strategy = Mockito.mock(MoveStrategy.class);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Car(null, strategy);
                }).withMessageMatching(CarConst.NULL_NAME_ERR);
    }

    @Test
    @DisplayName("movable 인 경우만 전진해야 한다.")
    void move() {
        MoveStrategy proceedStrategy = ProceedStrategy.getInstance();
        String movableName = "proceed";
        Car movableCar = new Car(movableName, proceedStrategy);

        MoveStrategy stopStrategy = StopStrategy.getInstance();
        String stoppedName = "stop";
        Car stoppedCar = new Car(stoppedName, stopStrategy);

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
}
