package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.dto.UserInput;
import racingcar.strategy.MovableNumberGeneratorStrategy;
import racingcar.strategy.NonMovableNumberGeneratorStrategy;
import racingcar.strategy.NumberGeneratorStrategy;
import racingcar.strategy.RandomNumberGeneratorStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@DisplayName("자동차 경주 테스트")
class RacingGameTest {

    @DisplayName("전진 전략으로 1회 레이스를 진행하면 모든 차들의 위치는 1이다")
    @Test
    void 전진_레이스_테스트() {
        NumberGeneratorStrategy numberGeneratorStrategy = new MovableNumberGeneratorStrategy();
        RacingGame racingGame = new RacingGame();

        Cars cars = new Cars(3);
        Scores scores = racingGame.race(cars, numberGeneratorStrategy);
        List<Integer> points = scores.findAllScores().stream()
                .mapToInt(Score::findPoint)
                .boxed()
                .collect(Collectors.toList());

        Assertions.assertThat(points).containsAll(Arrays.asList(1, 1, 1));
    }

    @DisplayName("정지 전략으로 1회 레이스를 진행하면 모든 차들의 위치는 0이다")
    @Test
    void 정지_레이스_테스트() {
        NumberGeneratorStrategy numberGeneratorStrategy = new NonMovableNumberGeneratorStrategy();
        RacingGame racingGame = new RacingGame();

        Cars cars = new Cars(3);
        Scores scores = racingGame.race(cars, numberGeneratorStrategy);
        List<Integer> points = scores.findAllScores().stream()
                .mapToInt(Score::findPoint)
                .boxed()
                .collect(Collectors.toList());

        Assertions.assertThat(points).containsAll(Arrays.asList(0, 0, 0));
    }

    @ParameterizedTest(name = "스코어의 결과 사이즈는 게임 라운드를 진행한 라운드 수와 같다")
    @ValueSource(ints = {3, 5, 7})
    void 라운드_테스트(Integer number) {
        UserInput userInput = new UserInput(2, number);
        RacingGame racingGame = new RacingGame(userInput);
        NumberGeneratorStrategy numberGeneratorStrategy = new RandomNumberGeneratorStrategy();

        List<Scores> scoresList = racingGame.startGame(numberGeneratorStrategy);

        Assertions.assertThat(scoresList).size().isEqualTo(number);
    }

}