package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.dto.Winners;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racingcar.RacingCarTestUtil.*;

public class CarsTest {
    private final String RACER_ONE = "tomo";
    private final String RACER_TWO = "poby";
    private final String RACER_THREE = "yong";
    private final String RACER_FOUR = "crong";

    private final int DISTANCE_OF_RACER_ONE = 3;
    private final int DISTANCE_OF_RACER_TWO = 5;
    private final int DISTANCE_OF_RACER_THREE = 4;
    private final int DISTANCE_OF_RACER_FOUR = 5;

    private final int WINNER_COUNT_ONE = 1;
    private final int WINNER_COUNT_TWO = 2;

    private final int INDICATOR_OF_ONE_CAR = 1;
    private final int INDICATOR_OF_ZERO_CAR = 0;

    private Cars cars = new Cars();;
    private CarFactory carFactory;
    private Car racerOne = new Car(RACER_ONE, DISTANCE_OF_RACER_ONE);
    private Car racerTwo = new Car(RACER_TWO, DISTANCE_OF_RACER_TWO);
    private Car racerThree = new Car(RACER_THREE, DISTANCE_OF_RACER_THREE);
    private Car racerFour = new Car(RACER_FOUR, DISTANCE_OF_RACER_FOUR);

    @BeforeEach
    void setUp() {
        carFactory = new CarFactory(NAMES_OF_CARS);
    }

    @Test
    void add() {
        cars.add(new Car(NAME_OF_CAR));
        assertThat(cars.sizeEqualTo(INDICATOR_OF_ONE_CAR)).isTrue();
        assertThat(cars.contains(new Car(NAME_OF_CAR))).isTrue();
    }

    @Test
    void contains() {
        cars = carFactory.buildCars();
        assertThat(cars.contains(new Car("pobi"))).isTrue();
        assertThat(cars.contains(new Car("tomo"))).isTrue();
        assertThat(cars.contains(new Car("crong"))).isTrue();
        assertThat(cars.contains(new Car("honux"))).isTrue();
        assertThat(cars.contains(new Car("yong"))).isTrue();
        assertThat(cars.contains(new Car("dane"))).isFalse();
    }

    @Test
    void sizeEqualTo() {
        cars = carFactory.buildCars();
        assertThat(cars.sizeEqualTo(NUMBER_OF_CARS)).isTrue();
    }

    @Test
    void clear() {
        cars = carFactory.buildCars();
        cars.clear();
        assertThat(cars.sizeEqualTo(INDICATOR_OF_ZERO_CAR)).isTrue();
    }

    @Test
    void decideSingleWinner() {
        addThreeRacersWithDifferentDistances();

        Winners winners = cars.chooseWinner();

        assertThat(winners.sizeEqualTo(WINNER_COUNT_ONE)).isTrue();
        assertThat(winners.contains(RACER_TWO)).isTrue();
    }

    @Test
    void decideMultipleWinners() {
        addThreeRacersWithDifferentDistances();
        cars.add(racerFour);

        Winners winners = cars.chooseWinner();

        assertThat(winners.sizeEqualTo(WINNER_COUNT_TWO)).isTrue();
        assertThat(winners.contains(RACER_TWO)).isTrue();
        assertThat(winners.contains(RACER_FOUR)).isTrue();
    }

    private void addThreeRacersWithDifferentDistances() {
        cars.clear();
        cars.add(racerOne);
        cars.add(racerTwo);
        cars.add(racerThree);
    }
}
