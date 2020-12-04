package step4.checkor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step4.Car;
import step4.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class ScoreCheckorTest {

    private static final int CAN_MOVE_CAR_NUMBER = 9;
    private static final String CARS = "pobi,crong,honux";
    private Checkor scoreCheckor;
    private List<Driver> drivers;

    @BeforeEach
    void setUp() {
        scoreCheckor = new ScoreCheckor();
        drivers = new ArrayList<>();
    }

    @ParameterizedTest
    @MethodSource("generateDriversData")
    @DisplayName("우승자 점수를 판단하는 기능 테스트")
    void winnerTest(int[] distance, int expectedScore) {
        String[] carArray = CARS.split(",");
        for (int i = 0; i < carArray.length; i++) {
            Driver driver = new Driver(new Car(carArray[i]));
            drive(driver, distance[i]);
            drivers.add(driver);
        }
        assertThat(scoreCheckor.check(drivers)).isEqualTo(expectedScore);
    }

    static Stream<Arguments> generateDriversData() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 1}, 3),
                Arguments.of(new int[]{1, 3, 1}, 3),
                Arguments.of(new int[]{5, 5, 5}, 5)
        );
    }

    private void drive(Driver driver, int distance) {
        for (int i = 0; i < distance; i++) {
            driver.drive(CAN_MOVE_CAR_NUMBER);
        }
    }

}