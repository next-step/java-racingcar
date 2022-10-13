package racing.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    @DisplayName("정상적으로 내림차순으로 정렬하는지 확인")
    void testSortDesc() {
        Car car1 = new Car("jason");
        Car car2 = new Car("ethan");
        Car car3 = new Car("pat");
        Mover mover = new Mover();
        mover.decideMove(car3, 9);
        mover.decideMove(car3, 9);
        mover.decideMove(car1, 7);
        Cars cars = Cars.makeCars(car1, car2, car3);

        cars.sortDesc();

        Cars expected = Cars.makeCars(car3, car1, car2);
        assertThat(cars).isEqualTo(expected);
    }

    @Test
    @DisplayName("같은 거리값을 가진 자동차 리스트 반환 확인")
    void testGetCarsWithSameDistance(){
        Car car1 = new Car("jason");
        Car car2 = new Car("ethan");
        Car car3 = new Car("pat");
        Mover mover = new Mover();
        mover.decideMove(car3, 9);
        mover.decideMove(car3, 9);
        mover.decideMove(car1, 7);
        mover.decideMove(car1, 7);
        Cars cars = Cars.makeCars(car1, car2, car3);

        Cars result = cars.getCarsWithSameDistance(3);

        Cars expected = Cars.makeCars(car1, car3);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("문자열이 주어졌을 때 자동차 리스트 반환 확인")
    void testMakeCarWithString(){
        String input = "jack,pat,ethan";

        Cars result = Cars.makeCars(input);

        Car car1 = new Car("jack");
        Car car2 = new Car("pat");
        Car car3 = new Car("ethan");
        Cars expected = Cars.makeCars(car1, car2, car3);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("정상적인 한명의 우승자를 반환하는지 확인")
    void testGettingOneWinner() {
        Car car1 = new Car("jason");
        Car car2 = new Car("ethan");
        Car car3 = new Car("pat");
        Mover mover = new Mover();
        mover.decideMove(car1, 9);
        mover.decideMove(car1, 9);

        Cars winners = Cars.makeCars(car1, car2, car3).getWinners();

        Cars expectedResult = Cars.makeCars(car1);

        assertThat(winners).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("정상적인 복수의 우승자를 반환하는지 확인")
    void testGettingWinners() {
        Car car1 = new Car("jason");
        Car car2 = new Car("ethan");
        Car car3 = new Car("pat");
        Mover mover = new Mover();
        mover.decideMove(car1, 9);
        mover.decideMove(car1, 9);
        mover.decideMove(car2, 5);
        mover.decideMove(car2, 7);

        Cars winners = Cars.makeCars(car1, car2, car3).getWinners();

        Cars expectedResult = Cars.makeCars(car1, car2);
        assertThat(winners).isEqualTo(expectedResult);
    }

}
