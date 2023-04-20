package study.racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.racing.domain.Car;
import study.racing.controller.RacingGame;
import study.racing.view.InputView;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {

    private static final int INITIAL_CAR_NUMBER = 10;
    private static final String INITIAL_CAR_NAMES = "car1,car2,car3,car4,car5,car6,car7,car8,car9,car10";
    private List<Car> initialCars = new ArrayList<>();
    private static final int FINAL_CAR_NUMBER = 5;
    private List<Car> finalCars = new ArrayList<>();

    private RacingGame racingGame;

    @BeforeEach
    void settingCars() {
        initialCars = InputView.readCars(INITIAL_CAR_NAMES);
        finalCars.add(new Car(1, "car1"));
        finalCars.add(new Car(3, "car2"));
        finalCars.add(new Car(5, "car3"));
        finalCars.add(new Car(5, "car4"));
        finalCars.add(new Car(2, "car5"));

        racingGame = new RacingGame();
    }

    @Test
    void 전진_가능_로직_테스트() {
        Car before = new Car(1, "car");
        Car after = racingGame.moveOrStop(before);

        assertThat(after.getCurrentLocation()).isGreaterThanOrEqualTo(before.getCurrentLocation());
        assertThat(after.getCurrentLocation() - before.getCurrentLocation()).isLessThanOrEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "0, false",
            "3, false",
            "4, true",
            "9, true"
    })
    void 랜덤_결과로_전진가능_테스트(int randomValue, boolean canMove) {
        Car car = new Car(1, "car");
        assertThat(car.canMove(randomValue)).isEqualTo(canMove);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1, 2",
            "99, 100"
    })
    void 전진하면_1만큼_전진(int before, int after) {
        Car car = new Car(before, "car");
        car.moveForward();
        assertThat(car.getCurrentLocation()).isEqualTo(after);
    }

    @Test
    void 가장_멀리_이동한_거리() {
        int longestDistance = racingGame.getLongestDistance(finalCars);
        assertThat(longestDistance).isEqualTo(5);
    }

    @Test
    void 특정_위치의_자동차를_리스트에_추가() {
        List<Car> carsWithLocation = new ArrayList<>();
        racingGame.getCarsWithLocation(5, carsWithLocation, new Car(5, "car"));
        assertThat(carsWithLocation).hasSize(1);
        assertThat(carsWithLocation.get(0).getName()).isEqualTo("car");
    }

    @Test
    void 특정_위치의_자동차가_아니라면_리스트에_추가_X() {
        List<Car> carsWithLocation = new ArrayList<>();
        racingGame.getCarsWithLocation(5, carsWithLocation, new Car(3, "car"));
        assertThat(carsWithLocation).isEmpty();
    }

    @Test
    void 최종_우승한_자동차() {
        List<Car> winningCars = racingGame.getWinningCars(finalCars);
        assertThat(winningCars).hasSize(2);
    }
}
