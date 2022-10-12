package racing.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RefereeTest {

    private final Referee referee = new Referee();

    @Test
    @DisplayName("정상적인 한명의 우승자를 반환하는지 확인")
    void testGettingOneWinner() {
        Car car1 = new Car("jason");
        Car car2 = new Car("ethan");
        Car car3 = new Car("pat");
        Mover mover = new Mover();
        mover.decideMove(car1, 9);
        mover.decideMove(car1, 9);

        CarList winners = referee.getWinners(CarList.makeCars(car1, car2, car3));

        CarList expectedResult = CarList.makeCars(car1);

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

        CarList winners = referee.getWinners(CarList.makeCars(car1, car2, car3));

        CarList expectedResult = CarList.makeCars(car1, car2);
        assertThat(winners).isEqualTo(expectedResult);
    }
}
