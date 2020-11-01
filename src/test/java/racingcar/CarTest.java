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
        if (name.length() <= NumConst.MAX_NAME_LENGTH) {
            Assertions.assertDoesNotThrow(() -> {
                new Car(name, strategy);
            });
            return;
        }
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Car(name, strategy);
                }).withMessageMatching(MsgConst.MAX_NAME_LENGTH_EXCEEDED);
    }

    @Test
    @DisplayName("movable 인 경우만 전진해야 한다.")
    void move() {
        MoveStrategy movableStrategy = new MoveStrategy() {
            @Override
            public boolean checkMovable() {
                return true;
            }
        };
        String movableName = "move";
        Car movableCar = new Car(movableName, movableStrategy);

        MoveStrategy stopStrategy = new MoveStrategy() {
            @Override
            public boolean checkMovable() {
                return false;
            }
        };
        String stoppedName = "stop";
        Car stoppedCar = new Car(stoppedName, stopStrategy);


        movableCar.move();
        stoppedCar.move();

        int movedPosition = 2;
        int stoppedPosition = 1;
        assertThat(movableCar.getPosition())
                .isEqualTo(movedPosition);
        assertThat(stoppedCar.getPosition())
                .isEqualTo(stoppedPosition);
    }
}
