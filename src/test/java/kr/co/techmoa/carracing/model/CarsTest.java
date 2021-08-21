package kr.co.techmoa.carracing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @DisplayName(value = "Cars 동작 테스트")
    @CsvSource("A,B,C")
    @ParameterizedTest
    void roundOneTry(String carA, String carB, String carC) {
        String[] names = {carA, carB, carC};
        Cars cars = new Cars(names);
        cars.roundOneTry();
        List<Car> carList = cars.getCars();

        assertEquals(carList.size(), names.length );
    }
}