package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GameResultTestRefactoring {
    final static int DEFAULT_MOVE_VALUE = 2;
    final static int CAR_INITIAL_POSITION = 1;
    final static int FIRST_CAR_DEFAULT_POTITION = 3;
    final static int SECOND_CAR_DEFAULT_POTITION = 2;
    final static int THIRD_CAR_DEFAULT_POTITION = 1;
    final static int DEFAULT_NUMBER_OF_CARS = 3;

    CarState defaultCarState;
    CarDisplacement defaultCarDisplacement;
    Car defaultCar;
    Car firstCar;
    Car secondCar;
    Car thirdCar;
    GameResult defaultGameResult;
    List<Car> defaultCars;

    @BeforeEach
    void setUp() {
        defaultCarState = DefaultCarState.create(CAR_INITIAL_POSITION);
        defaultCarDisplacement = DefaultCarDisplacement.create(DEFAULT_MOVE_VALUE);
        defaultCar = Car.createCar(defaultCarState, defaultCarDisplacement);

        firstCar = Car.createCar(DefaultCarState.create(FIRST_CAR_DEFAULT_POTITION), defaultCarDisplacement);
        secondCar = Car.createCar(DefaultCarState.create(SECOND_CAR_DEFAULT_POTITION), defaultCarDisplacement);
        thirdCar = Car.createCar(DefaultCarState.create(THIRD_CAR_DEFAULT_POTITION), defaultCarDisplacement);

        defaultCars = new ArrayList<>();
        defaultCars.add(firstCar);
        defaultCars.add(secondCar);
        defaultCars.add(thirdCar);
        defaultGameResult = GameResult.create(defaultCars);
    }

    @Test
    @DisplayName("초기화된 GameResult 생성 테스트")
    void createInitialGameResult() {
        GameResult initialGameResult = GameResult.createInitialGameResult(new NumberOfCars(DEFAULT_NUMBER_OF_CARS));

        List<Car> cars = new ArrayList<>();
        cars.add(defaultCar);
        cars.add(defaultCar);
        cars.add(defaultCar);

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
            copyOfCars.add(Car.createCopy(car));
        }
        assertEquals(GameResult.create(copyOfCars), defaultGameResult);
    }

    @Test
    @DisplayName("GameResult toString test")
    void testToString() {
        assertEquals("[{position : 3}, {position : 2}, {position : 1}]", defaultGameResult.toString());
    }
}
