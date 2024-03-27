import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author jeongheekim
 * @date 3/27/24
 */
class WinnerTest {

    @Test
    @DisplayName("우승자는 한명 이상이다.")
    void winnerLengthTest() {
        SmallCar car = new SmallCar("pobi");
        car.drive(7, "-");

        Car[] cars = new Car[1];
        cars[0] = car;

        Winner winner = new Winner();
        List<String> winners = winner.getWinners(cars);

        assertTrue(winners.size() >= 1);
    }

}
