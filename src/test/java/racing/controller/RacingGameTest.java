package racing.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racing.strategy.DefaultMoveStategy;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    static racing.RacingGame racingGame;





    @DisplayName("레이싱게임 시작")
    @ParameterizedTest
    @MethodSource("getRacingGameParamter")
    public void 레이싱게임시작(int countOfRacing, String[] racingCarInput, int[] expected) {
        DefaultMoveStategy stategy = new DefaultMoveStategy();
        racingGame = new RacingGame(countOfRacing);
        racingGame.start(racingCarInput, stategy);
        assertThat(racingGame.getRacingCars().getRecingCarList()).extracting("racingResult").isEqualTo(expected);
    }


    static Stream<Arguments> getRacingGameParamter() {

        return Stream.of(
                Arguments.of(4, new String[]{"에디, 경현"}, new int[]{4})
        );
    }


}
