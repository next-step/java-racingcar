package ThirdStep;

import ThirdStep.model.Car;
import ThirdStep.model.CarRequest;
import ThirdStep.services.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarServiceTest {

    private final CarService carService = new CarService();
    private Method getWinnersMethod;

    private final List<Car> cars = new ArrayList<>();

    @BeforeEach
    public void setGetWinnersMethod() throws NoSuchMethodException {
        getWinnersMethod = carService.getClass().getDeclaredMethod("getWinners", List.class);
        getWinnersMethod.setAccessible(true);
    }

    @BeforeEach
    public void setCars() {
        Car car1 = Car.of(new CarRequest("car1"));
        Car car2 = Car.of(new CarRequest("car2"));
        Car car3 = Car.of(new CarRequest("car3"));

        this.move(car1, 2);
        this.move(car2, 3);
        this.move(car3, 1);

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
    }

    private void move(Car car, int count) {
        while (count-- > 0) {
            car.move();
        }
    }

    @Test
    @DisplayName("가장 멀리 간 차가 한 대인 경우, 승자는 1명이고 이름은 car2이다.")
    void test1() throws InvocationTargetException, IllegalAccessException {
        List<Car> winner = (List<Car>) getWinnersMethod.invoke(carService, cars);

        assertThat(winner.size()).isEqualTo(1);
        assertThat(winner.get(0).getName()).isEqualTo("car2");
    }

    @Test
    @DisplayName("가장 멀리간 차가 두 대인 경우, 승자는 2명이고 이름은 car2, car4이다.")
    void test2() throws InvocationTargetException, IllegalAccessException {
        Car car4 = Car.of(new CarRequest("car4"));
        this.move(car4, 3);
        cars.add(car4);

        List<Car> winner = (List<Car>) getWinnersMethod.invoke(carService, cars);

        assertThat(winner.size()).isEqualTo(2);
        assertThat(winner.get(0).getName()).isEqualTo("car2");
        assertThat(winner.get(1).getName()).isEqualTo("car4");
    }


}
