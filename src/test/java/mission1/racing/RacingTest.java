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

        for (int p : positions) {
            racingGame.checkMaxPosition(p);
        }

        assertEquals(racingGame.getMaxPosition(), expected);
    }

    @DisplayName("우승자를 제대로 가져오는지 확인 - 파라미터와 동일한 경우 true 반환")
    @ParameterizedTest
    @CsvSource(value = {"1 : false", "3 : false", "5 : true", "6 : false", "0 : false"}, delimiter = ':')
    void testMaxPosition(int maxPosition, boolean expected) {
        Car car = new Car(5);
        assertEquals(car.isWinner(maxPosition), expected);
    }
}
