package ThirdStep;

import ThirdStep.model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarActionTest {

    private final CarAction carAction = new CarAction();
    private Method getWinnersMethod;

    private final List<Car> cars = new ArrayList<>();

    @BeforeEach
    public void setGetWinnersMethod() throws NoSuchMethodException {
        getWinnersMethod = carAction.getClass().getDeclaredMethod("getWinners", List.class);
        getWinnersMethod.setAccessible(true);
    }

    @BeforeEach
    public void setCars() {
        Car car1 = new Car();
        car1.setName("car1");
        car1.setLocation(10);
        cars.add(car1);

        Car car2 = new Car();
        car2.setName("car2");
        car2.setLocation(15);
        cars.add(car2);

        Car car3 = new Car();
        car3.setName("car3");
        car3.setLocation(5);
        cars.add(car3);
    }

    @Test
    @DisplayName("가장 멀리 간 차가 한 대인 경우, 승자는 1명이고 이름은 car2이다.")
    void test1() throws InvocationTargetException, IllegalAccessException {
        List<Car> winner = (List<Car>) getWinnersMethod.invoke(carAction, cars);

        assertThat(winner.size()).isEqualTo(1);
        assertThat(winner.get(0).getName()).isEqualTo("car2");
    }

    @Test
    @DisplayName("가장 멀리간 차가 두 대인 경우, 승자는 2명이고 이름은 car2, car4이다.")
    void test2() throws InvocationTargetException, IllegalAccessException {
        Car car4 = new Car();
        car4.setName("car4");
        car4.setLocation(15);
        cars.add(car4);

        List<Car> winner = (List<Car>) getWinnersMethod.invoke(carAction, cars);

        assertThat(winner.size()).isEqualTo(2);
        assertThat(winner.get(0).getName()).isEqualTo("car2");
        assertThat(winner.get(1).getName()).isEqualTo("car4");
    }


}
