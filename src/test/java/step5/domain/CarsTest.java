package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CarsTest {


    @DisplayName("cars 테스트")
    @Test
    void carsTest() {
        Car aa = new Car("aa", 1);
        Cars cars = new Cars(Arrays.asList(aa));

        assertTrue(cars.getCars().contains(aa));
    }

    @DisplayName("Winners 테스트 - 승자가 한명일 경우")
    @Test
    void carsWinnerTest(){
        Car aa = new Car("aa", 2);
        Car bb = new Car("bb", 1);
        Cars cars = new Cars(Arrays.asList(aa, bb));

        List<Car> winners = cars.getWinners();

        assertTrue(winners.contains(aa));
    }

    @DisplayName("Winners 테스트 - 승자가 여러명일 경우")
    @Test
    void carsWinnersTest() {
        Car aa = new Car("aa", 2);
        Car bb = new Car("bb", 1);
        Car cc = new Car("cc", 2);
        Cars cars = new Cars(Arrays.asList(aa, bb, cc));

        List<Car> winners = cars.getWinners();

        assertTrue(winners.containsAll(Arrays.asList(aa, cc)));
    }
    
    
}