package racing.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.model.Car;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("4단계 - 우승자 - CarRacingController 단위 테스트")
class CarRacingControllerTest {

    CarRacingController carRacingController;

    @BeforeEach
    void setUp() {
        carRacingController = new CarRacingController();
    }

    @Test
    @DisplayName("우승자 추출 - 1명")
    void extractWinner()
            throws InvocationTargetException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException {
        List<Car> cars = createMockCarsContainingOneWinner();
        setUpCarRacingController(cars);

        List<Car> actualWinners = invokeMethodExtractWinners();

        assertThat(actualWinners)
                .containsExactlyElementsOf(cars.subList(0, 1));
    }

    private List<Car> createMockCarsContainingOneWinner()
            throws NoSuchFieldException, IllegalAccessException {
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        car1.setName("1");
        car2.setName("2");
        car3.setName("3");

        Field movingDistanceField = Car.class
                .getDeclaredField("movingDistance");
        movingDistanceField.setAccessible(true);
        movingDistanceField.setInt(car1, 3);
        movingDistanceField.setInt(car2, 2);
        movingDistanceField.setInt(car3, 1);

        return Arrays.asList(car1, car2, car3);
    }

    @Test
    @DisplayName("우승자 추출 - 2명")
    void extractTwoWinners()
            throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        List<Car> cars = createMockCarsContainingTwoWinners();
        setUpCarRacingController(cars);

        List<Car> actualWinners = invokeMethodExtractWinners();

        assertThat(actualWinners)
                .containsExactlyElementsOf(cars.subList(1, 3));
    }

    private List<Car> createMockCarsContainingTwoWinners()
            throws NoSuchFieldException, IllegalAccessException {
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        car1.setName("1");
        car2.setName("2");
        car3.setName("3");

        Field movingDistanceField = Car.class
                .getDeclaredField("movingDistance");
        movingDistanceField.setAccessible(true);
        movingDistanceField.setInt(car1, 1);
        movingDistanceField.setInt(car2, 3);
        movingDistanceField.setInt(car3, 3);

        return Arrays.asList(car1, car2, car3);
    }

    private void setUpCarRacingController(List<Car> cars)
            throws NoSuchFieldException, IllegalAccessException {
        Field carsField = CarRacingController.class
                .getDeclaredField("cars");
        carsField.setAccessible(true);
        carsField.set(carRacingController, cars);
    }

    private List<Car> invokeMethodExtractWinners()
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method methodExtractWinners = CarRacingController.class
                .getDeclaredMethod("extractWinners");
        methodExtractWinners.setAccessible(true);
        return (List<Car>) methodExtractWinners.invoke(carRacingController);
    }
}