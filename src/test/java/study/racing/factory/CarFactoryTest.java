package study.racing.factory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.racing.domain.Car;
import study.racing.domain.DefaultMovingCondition;
import study.racing.domain.MovingCondition;
import study.racing.domain.RandomMovingCondition;
import study.racing.factory.CarFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarFactoryTest {

    public MovingCondition movingCondition = new DefaultMovingCondition();

    @Test
    @DisplayName("CreateCar는 해당하는 이름을 가진 차량을 생성한다.")
    void isCreateCars_ShouldReturnCarsAccordingToName() {
        String[] names = "pobi,crong,honux".split(",");
        int carCount = names.length;

        List<Car> cars = CarFactory.createCars(carCount, names, movingCondition);
        List<String> nameList = Arrays.asList(names);

        assertThat(cars.stream()
                .allMatch(car -> nameList.contains(car.getName())))
                .isTrue();
    }
}
