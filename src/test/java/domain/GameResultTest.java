package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameResultTest {
    final static int CAR_INITIAL_POSITION = 1;
    final static int FIRST_CAR_DEFAULT_POTITION = 3;
    final static int SECOND_CAR_DEFAULT_POTITION = 2;
    final static int THIRD_CAR_DEFAULT_POTITION = 1;
    final static int DEFAULT_NUMBER_OF_CARS = 3;

    GameResult defaultGameResult;
    List<Car> defaultCars;

    @BeforeEach
    void setUp() {
        defaultCars = new ArrayList<>();
        defaultCars.add(new Car(FIRST_CAR_DEFAULT_POTITION));
        defaultCars.add(new Car(SECOND_CAR_DEFAULT_POTITION));
        defaultCars.add(new Car(THIRD_CAR_DEFAULT_POTITION));
        defaultGameResult = GameResult.create(defaultCars);
    }

    @Test
    @DisplayName("초기화된 GameResult 생성 테스트")
    void createInitialGameResult() {
        GameResult initialGameResult = GameResult.createInitialGameResult(new NumberOfCars(DEFAULT_NUMBER_OF_CARS));

        List<Car> cars = new ArrayList<>();
        cars.add(new Car(CAR_INITIAL_POSITION));
        cars.add(new Car(CAR_INITIAL_POSITION));
        cars.add(new Car(CAR_INITIAL_POSITION));

        assertEquals(GameResult.create(cars), initialGameResult);
    }

    @Test
    @DisplayName("GameResult copy 생성 테스트")
    void createCopy() {
        assertEquals(defaultGameResult, GameResult.createCopy(defaultGameResult));
    }

    @Test
    @DisplayName("GameResult 생성 테스트")
    void create() {
        assertDoesNotThrow(() -> GameResult.create(defaultCars));
    }

    @Test
    @DisplayName("GameResult의 cars 가져오기 테스트")
    void getCars() {
        assertEquals(defaultCars, defaultGameResult.getCars());
    }

    @Test
    @DisplayName("객체의 주소가 다르지만 값이 같을 경우 equals test")
    void testEquals() {
        List<Car> copyOfCars = new ArrayList<>();
        for (Car car : defaultCars) {
            copyOfCars.add(new Car(car));
        }
        assertEquals(GameResult.create(copyOfCars), defaultGameResult);
    }

    @Test
    @DisplayName("GameResult toString test")
    void testToString() {
        assertEquals("[{location : 3}, {location : 2}, {location : 1}]", defaultGameResult.toString());
    }
}
