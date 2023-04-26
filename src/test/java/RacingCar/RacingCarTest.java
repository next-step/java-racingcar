package RacingCar;

import RacingCar.Input.Input;
import RacingCar.Output.Output;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest {

    @Test
    @DisplayName("자동차가 앞으로 잘 이동하는지")
    void moveCarTest() {

        //given
        Car car = new Car(1, "pobi");

        //when
        car.move(6);

        //then
        int expected = 2;
        int acutal = car.getLocation();
        assertEquals(expected, acutal);

    }

    @Test
    @DisplayName("우승자의 이름을 잘 알려주는지")
    void addWinnerTest() {

        //given
        RacingCar racingCar = new RacingCar();

        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(new Car(3, "pobi"));
        cars.add(new Car(4, "crong"));
        cars.add(new Car(4, "honux"));
        ArrayList<Car> winners = new ArrayList<Car>();

        //when
        for (Car car : cars)
            racingCar.addWinner(car, car.chooseWinner(cars));

        //then
        String[] expected = {"crong", "honux"};

        for (int i = 0; i < winners.size(); i++)
            assertEquals(expected[i], winners.get(i).getName());


    }

    @Test
    @DisplayName("input 시 자동차 이름은 5자 초과할때 확인")
    void checkInputCarNameOver5() {

        //given
        String[] carName = {"abcdef"};
        Input input = new Input();

        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            input.checkCarNameLength(carName);
        });

        String expected = "abcdef의 자동차 이름은 5자 이하여야 합니다.";
        String actual = exception.getMessage();
        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("자동차 이름은 5자 초과할때 확인")
    void checkCarNameOver5() {

        //given,when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Car car = new Car(1,"abcdef");
        });

        //then
        String expected = "abcdef의 자동차 이름은 5자 이하여야 합니다.";
        String actual = exception.getMessage();
        assertEquals(expected, actual);

    }
}