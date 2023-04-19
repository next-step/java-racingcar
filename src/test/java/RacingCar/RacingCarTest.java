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

        //when
        String[] carName = new String[]{"pobi", "crong", "honux"};

        ArrayList<Car> cars = new ArrayList<Car>();
        for (int i = 0; i < carName.length; i++)
            cars.add(new Car(1, carName[i]));

        //given
        for (Car car : cars)
            if (true) car.setLocation(car.getLocation() + 1);

        //then

        for (Car car : cars) {
            int expected = 2;
            int acutal = car.getLocation();
            assertEquals(expected, acutal);
        }
    }

    @Test
    @DisplayName("우승자의 움직임 횟수를 잘 측정하는지")
    void getMaxLocationTest() {

        //when
        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(new Car(3, "pobi"));
        cars.add(new Car(4, "crong"));
        cars.add(new Car(5, "honux"));

        ArrayList<Winner> winners = new ArrayList<Winner>();
        int maxLocation = 0;
        //given
        for (Car car : cars)
            if (car.getLocation() > maxLocation) maxLocation = car.getLocation();

        //then
        int expected = 5;
        int actual = maxLocation;
        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("우승자의 이름을 잘 알려주는지")
    void addWinnerTest() {

        //when
        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(new Car(3, "pobi"));
        cars.add(new Car(4, "crong"));
        cars.add(new Car(4, "honux"));

        ArrayList<Winner> winners = new ArrayList<Winner>();
        int maxLocation = 0;

        for (Car car : cars)
            if (car.getLocation() > maxLocation) maxLocation = car.getLocation();

        //given
        for (Car car : cars)
            if (maxLocation == car.getLocation()) winners.add(new Winner(car.getName()));

        //then
        String[] expected = {"crong", "honux"};

        for (int i = 0; i < winners.size(); i++)
            assertEquals(expected[i], winners.get(i).getName());


    }

    @Test
    @DisplayName("자동차 이름은 5자 초과할때 확인")
    void checkCarNameOver5() {

        //when
        String[] carName = {"abcdef"};
        Input input = new Input();

        //then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            input.checkCarNameLength(carName);
        });

        String expected = "abcdef의 자동차 이름은 5자 이하여야 합니다.";
        String actual = exception.getMessage();
        assertEquals(expected,actual);

    }

}