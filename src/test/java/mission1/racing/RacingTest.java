package mission1.racing;

import mission1.racing.model.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingTest {
    RacingRandom random = new RacingRandom();
    RacingGame racingGame = new RacingGame();

    @DisplayName("랜덤의 범위가 0~9인지 확인")
    @Test
    void testRandomRange() {
        int randomResult = random.random();
        assertTrue(randomResult >= 0 && randomResult < 10);
    }

    @DisplayName("maxPosition은 입력이 순서와 관계없이 가장 큰 숫자여야 한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,2,1 : 2", "1,2,3,4 : 4", "4,3,2,1 : 4", "0,0,0,0 : 0", "119,1,1,1 : 119"}, delimiter = ':')
    void testMaxPosition(String testNums, int expected) {
        String[] strNums = testNums.split(",");
        int[] positions = new int[strNums.length];

        for (int i = 0; i < strNums.length; i++) {
            positions[i] = Integer.parseInt(strNums[i]);
        }

        int max = 0;
        for (int p : positions) {
            max = racingGame.checkMaxPosition(max, p);
        }

        assertEquals(max, expected);
    }

    @DisplayName("maxPosition과 동일한 위치에 있는 차는 우승한다. ")
    @ParameterizedTest
    @CsvSource(value = {"1,2,2,10 : 1", "1,2,3,4 : 0", "10,10,10,10 : 4"}, delimiter = ':')
    void testAddWinner(String strPosition, int numberOfWinners) {
        int maxPosition = 10;

        String[] strNums = strPosition.split(",");
        Car[] cars = new Car[strNums.length];

        for (int i = 0; i < strNums.length; i++) {
            cars[i] = new Car(Integer.parseInt(strNums[i]));
        }

        for (Car car : cars) {
            racingGame.addWinner(car, maxPosition);
        }

        assertEquals(racingGame.getWinnersArrayList().size(), numberOfWinners);
    }
}

