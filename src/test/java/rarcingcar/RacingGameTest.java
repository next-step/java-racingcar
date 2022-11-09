package rarcingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.Car;
import racingcar.RacingGame;

public class RacingGameTest {

    @Test
    public void car_이동_테스트() {
        RacingGame racingGame = new RacingGame() {
            @Override
            protected int getRandomNumber() {
                return 3;
            }
        };

        RacingGame racingGame2 = new RacingGame() {
            @Override
            protected int getRandomNumber() {
                return 5;
            }
        };

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car(3));
        cars.add(new Car(5));
        cars.add(new Car(2));

        ArrayList<Car> cars2 = new ArrayList<>();
        cars2.add(new Car(3));
        cars2.add(new Car(5));
        cars2.add(new Car(2));

        final List<Car> carsMovedRandom = racingGame.carMoveRandom(cars);
        final List<Car> carsMovedRandom2 = racingGame2.carMoveRandom(cars2);
        assertAll(
            () -> assertThat(carsMovedRandom.get(0)).isEqualTo(new Car(3)),
            () -> assertThat(carsMovedRandom.get(1)).isEqualTo(new Car(5)),
            () -> assertThat(carsMovedRandom.get(2)).isEqualTo(new Car(2)),
            () -> assertThat(carsMovedRandom2.get(0)).isEqualTo(new Car(4)),
            () -> assertThat(carsMovedRandom2.get(1)).isEqualTo(new Car(6)),
            () -> assertThat(carsMovedRandom2.get(2)).isEqualTo(new Car(3))
        );
    }
}
