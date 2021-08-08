package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import step4.model.Car;
import step4.model.Cars;
import step4.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class CarRacingTest {
    @Test
    @DisplayName("이름을 5자 이상 입력하면 안된다.")
    public void should_not_inserted_over_5() {
        //given
        String carName = "carcarcar";

        //when
        InputView view = new InputView();

        //then
        assertTrue(view.isOverLength(carName));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("이름 null 또는 빈문자열이 들어오면 안된다.")
    public void should_return_false_for_null_and_empty_strings(String input) {
        //when
        InputView view = new InputView();

        //then
        assertTrue(view.isBlank(input));
    }

    @Test
    @DisplayName("차 이름을 분리해서 세팅한다.")
    public void set_car_name() {
        //given
        String carName = "car1,car2,car3";
        String[] expect = {"car1", "car2", "car3"};

        //when
        InputView view = new InputView();
        String[] names = view.splitName(carName);

        //then
        for (int i=0; i<names.length; i++) {
            assertEquals(expect[i], names[i]);
        }
    }

    @Test
    @DisplayName("자동차수를 입력받아 자동차 수만큼 세팅한다.")
    public void set_cars() {
        //given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        List<Car> carList = new ArrayList<>();

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        //when
        Cars carSet = new Cars(carList);

        //then
        assertThat(carSet.getCars().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("4이상일 경우 자동차가 전진해야한다.")
    public void car_should_be_moved() {
        //given
        Car expected = new Car("test", 1);

        //when
        List<Car> carName = Arrays.asList(new Car("test"));
        Cars carSet = new Cars(carName);
        carSet.moveAll(()->true);

        //then
        carSet.getCars().forEach(car -> {
            assertThat(car).isEqualTo(expected);
        });
    }

    @Test
    @DisplayName("4미만일 경우 자동차가 움직이지 않아야한다.")
    public void car_should_be_not_moved() {
        //given
        Car expected = new Car("test", 0);

        //when
        List<Car> carName = Arrays.asList(new Car("test"));
        Cars carSet = new Cars(carName);
        carSet.moveAll(()->false);

        //then
        carSet.getCars().forEach(car -> {
            assertThat(car).isEqualTo(expected);
        });
    }

    @Test
    @DisplayName("우승자의 이름을 반환해야한다.")
    public void should_return_winners_name() {
        //given
        Car car1 = new Car("car1", 1);
        Car car2 = new Car("car2", 0);
        Car car3 = new Car("car3", 0);

        List<Car> expectedCars = new ArrayList<>();

        expectedCars.add(car1);
        expectedCars.add(car2);
        expectedCars.add(car3);

        //when
        Cars carSet = new Cars(expectedCars);
        List<String> topMoveCar = carSet.getTopMoveCar();

        //then
        assertThat(topMoveCar.get(0)).isEqualTo("car1");
    }


}
