package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarsTest {


    @DisplayName("cars 테스트")
    @Test
    void carsTest() {
        Car aa = new Car("aa", 1);
        Cars cars = new Cars(Arrays.asList("aa"));

        assertTrue(cars.getCars().contains(aa));
    }

    @DisplayName("Winners 테스트 - 승자가 한명일 경우")
    @Test
    void carsWinnerTest(){
        Car aa = new Car("aa", 2);

        Cars cars = new Cars(Arrays.asList("aa", "bb"));
        cars.move(new RandomMove());

        List<Car> winners = cars.getWinners();
        assertTrue(winners.contains(aa));
    }

    @DisplayName("Winners 테스트 - 승자가 여러명일 경우")
    @Test
    void carsWinnersTest() {
        Car aa = new Car("aa", 2);
        Car cc = new Car("cc", 2);

        Cars cars = new Cars(Arrays.asList("aa", "bb", "cc"));
        cars.move(new RandomMove());

        List<Car> winners = cars.getWinners();

        assertTrue(winners.containsAll(Arrays.asList(aa, cc)));
    }

    @DisplayName("Move Test - Move 일 경우")
    @Test
    void carsMoveTest() {
        Cars cars = new Cars(Arrays.asList("aa", "bb", "cc"));
        cars.move(new Go());

        List<Car> movedCars = cars.getCars();
        Car movedCar = movedCars.get(0);
        int position = movedCar.getPosition().getPosition();
        int expected = 2;

        assertEquals(position, expected);
    }

    @DisplayName("Move Test - Stop 일 경우")
    @Test
    void carsStopTest() {
        Cars cars = new Cars(Arrays.asList("aa", "bb", "cc"));
        cars.move(new Stop());

        List<Car> movedCars = cars.getCars();
        Car movedCar = movedCars.get(0);
        int position = movedCar.getPosition().getPosition();
        int expected = 1;

        assertEquals(position, expected);
    }
    
}