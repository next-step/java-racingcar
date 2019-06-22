package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racing.domain.Cars;

public class CarsTest {
    private final static int CANT_MOVABLE_NUMBER = 3;
    private final static int CAN_MOVABLE_NUMBER = 4;
    private final static int MOVE_POINT_ONE = 1;
    private final static int MOVE_POINT_ZERO = 0;
    
    @Test
    void getCopiedCarTest() {
        Cars cars = new Cars(TestData.getNewDefaultCarsForTest());
        Cars copiedCar = cars.getCopiedCars();
        Assertions.assertThat(cars).isNotSameAs(copiedCar);
        Assertions.assertThat(cars.getCars()).isNotSameAs(copiedCar.getCars());
        Assertions.assertThat(cars.getCars().get(0)).isNotSameAs(copiedCar.getCars().get(0));
    }
    
    @Test
    void getCarNamesTest() {
        Cars cars = new Cars(TestData.getNewDefaultCarsForTest());
        Assertions.assertThat(cars.getCarNames()).isEqualTo(TestData.DEFAULT_CAR_NAME);
    }
    
    @Test
    void moveCarsSuccessTest() {
        Cars cars = new Cars(TestData.getNewDefaultCarsForTest());
        Assertions.assertThat(isAllCarMoved(cars.moveCars(() -> CAN_MOVABLE_NUMBER)))
          .isTrue();
    }
    
    private boolean isAllCarMoved(Cars cars) {
        return cars.getCars().stream()
          .allMatch(car -> car.getPosition() == MOVE_POINT_ONE);
    }
    
    @Test
    void moveCarsFailTest() {
        Cars cars = new Cars(TestData.getNewDefaultCarsForTest());
        Assertions.assertThat(isAllCarCantMoved(cars.moveCars(() -> CANT_MOVABLE_NUMBER))).isTrue();
    }
    
    private boolean isAllCarCantMoved(Cars cars) {
        return cars.getCars().stream()
          .allMatch(car -> car.getPosition() == MOVE_POINT_ZERO);
    }
    
    @Test
    void getWinnerTest() {
        Cars cars = TestData.GAME_ENDED_CARS;
        Assertions.assertThat(isWinnerNamesHasWinner(cars)).isTrue();
    }
    
    private boolean isWinnerNamesHasWinner(Cars cars) {
        return cars.getWinner().getCars().stream()
          .allMatch(car -> TestData.WINNER_NAMES.contains(car.getName()));
    }
}
