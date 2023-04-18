package RacingCar;

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

}