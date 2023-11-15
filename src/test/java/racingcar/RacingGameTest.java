package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.utils.NumberGenerator;

public class RacingGameTest {

    @Test
    @DisplayName("자동차 경주 통합 테스트")
    void racingGameTest() {
        int tryCount = 3;
        List<String> carNames = List.of("스포티지", "소렌토");

        RacingGame racingGame = new RacingGame(carNames, tryCount);
        racingGame.play(new FixedNumberGenerator(List.of(5, 1, 5, 1, 5, 1)));
        List<String> winnerCarNames
            = racingGame.getWinners().stream().map(Car::getCarName).collect(Collectors.toList());

        assertThat(winnerCarNames).contains("스포티지");
    }


    class FixedNumberGenerator implements NumberGenerator {

        private final Iterator<Integer> numbersIterator;

        public FixedNumberGenerator(List<Integer> numbers) {
            this.numbersIterator = numbers.iterator();
        }

        @Override
        public int generateNumber() {
            return numbersIterator.next();
        }
    }

}
