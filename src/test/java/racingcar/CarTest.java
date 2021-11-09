package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    private static final String NOT_AVAILIABLE_NAME = "hihihi";
    private static final String AVAILIABLE_NAME = "hello";
    private static final int ENOUGH_FUEL = randomInteger(4, 10);
    private static final int NOT_ENOUGH_FUEL = randomInteger(0, 10);

    private static int randomInteger(int min, int max) {
        return min + (int) (Math.random() * (max - min));
    }

    @Test
    void nameValidationPass() {
        Car car = new Car(
                new Info(AVAILIABLE_NAME, new Makable()),
                new Movable()
        );
    }

    @Test
    void nameValidationFail() {
        assertThatThrownBy(() -> {
            Car car = new Car(
                    new Info(NOT_AVAILIABLE_NAME, new Makable()),
                    new Movable()
            );
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void moveForward() {
        Car car = new Car(
                new Info(AVAILIABLE_NAME, new Makable()),
                new Movable()
        );

        Car forwardCar = new Car(
                new Info(AVAILIABLE_NAME, new Makable()),
                new Movable()
        );

        car.move(ENOUGH_FUEL);
        forwardCar.move(ENOUGH_FUEL);

        assertThat(car).isEqualTo(forwardCar);
    }

    @Test
    void moveStop() {
        Car car = new Car(
                new Info(AVAILIABLE_NAME, new Makable()),
                new Movable()
        );

        Car stopCar = new Car(
                new Info(AVAILIABLE_NAME, new Makable()),
                new Movable()
        );

        car.move(NOT_ENOUGH_FUEL);
        stopCar.move(NOT_ENOUGH_FUEL);

        assertThat(car).isEqualTo(stopCar);
    }

    @Test
    void winner() {
        RacingGame game = new RacingGame("E1,E2,E3", 5);
        game.start();
        List<Car> winners = game.winners();
    }
}
