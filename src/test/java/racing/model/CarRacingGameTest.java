package racing.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

@DisplayName("CarRacingGame 단위 테스트")
class CarRacingGameTest {

    List<String> carNames;
    CarRacingGame carRacingGame;

    @BeforeEach
    void setUp() {
        carNames = Arrays.asList("1", "2", "3");
        carRacingGame = new CarRacingGame(carNames, 0);
    }

    @Test
    @DisplayName("4단계 - 우승자 - 우승자 추출 - 1명")
    void extractWinners()
            throws NoSuchFieldException, IllegalAccessException {
        List<Integer> carMovingDistances = Arrays.asList(3, 2, 1);
        List<Car> cars = createMockCars(carNames, carMovingDistances);
        setUpMockCars(cars);

        List<Car> actualWinners = carRacingGame.extractWinners();

        assertThat(actualWinners)
                .containsExactlyElementsOf(cars.subList(0, 1));
    }

    @Test
    @DisplayName("4단계 - 우승자 - 우승자 추출 - 2명")
    void extractWinnersTwo()
            throws NoSuchFieldException, IllegalAccessException {
        List<Integer> carMovingDistances = Arrays.asList(3, 3, 1);
        List<Car> cars = createMockCars(carNames, carMovingDistances);
        setUpMockCars(cars);

        List<Car> actualWinners = carRacingGame.extractWinners();

        assertThat(actualWinners)
                .containsExactlyElementsOf(cars.subList(0, 2));
    }

    private List<Car> createMockCars(List<String> names, List<Integer> movingDistances)
            throws NoSuchFieldException, IllegalAccessException {
        Field movingDistanceField = Car.class
                .getDeclaredField("movingDistance");
        movingDistanceField.setAccessible(true);

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            Car car = new Car(names.get(i));
            movingDistanceField.set(car, movingDistances.get(i));
            cars.add(car);
        }

        return cars;
    }

    private void setUpMockCars(List<Car> cars)
            throws NoSuchFieldException, IllegalAccessException {
        Field carsField = CarRacingGame.class
                .getDeclaredField("cars");
        carsField.setAccessible(true);
        carsField.set(carRacingGame, cars);
    }

    @Test
    void moveCars() {
        carRacingGame = new CarRacingGame(carNames, 1);

        carRacingGame.moveCars();
        // 예외 발생 안하면 성공
    }

    @Test
    @DisplayName("moveCars() - IllegalStateException 생성")
    void moveCarsIllegalStateException() {
        carRacingGame = new CarRacingGame(carNames, 0);

        assertThatIllegalStateException()
                .isThrownBy(() -> carRacingGame.moveCars());
    }

    @Test
    void isPossibleMove() {
        carRacingGame = new CarRacingGame(carNames, 0);
        assertThat(carRacingGame.isPossibleToMove())
                .isFalse();

        carRacingGame = new CarRacingGame(carNames, 1);
        assertThat(carRacingGame.isPossibleToMove())
                .isTrue();

    }
}