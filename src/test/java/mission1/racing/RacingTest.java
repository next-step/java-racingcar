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
    Car car = new Car(5);

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

    @DisplayName("우승자를 제대로 가져오는지 확인 - 파라미터와 동일한 경우 true 반환")
    @ParameterizedTest
    @CsvSource(value = {"1 : false", "3 : false", "5 : true", "6 : false", "0 : false"}, delimiter = ':')
    void testGetWinner(int maxPosition, boolean expected) {
        assertEquals(car.isWinner(maxPosition), expected);
    }

    @DisplayName("자동차의 이동이 제대로 이뤄지는지 확인 - 파라미터가 4이상일때 true return")
    @ParameterizedTest
    @CsvSource(value = {"1 : false", "3 : false", "5 : true", "6 : true", "0 : false"}, delimiter = ':')
    void testCarMovementCondition(int randomValue, boolean expected) {
        assertEquals(car.moveCondition(randomValue), expected);
    }
}

