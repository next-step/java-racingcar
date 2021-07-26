package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.dto.Board;
import racingcar.dto.RacingInfo;
import racingcar.model.Cars;
import racingcar.strategy.impl.RandomBoundMovingStrategy;
import racingcar.util.InputCarNameSplitUtils;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTests {

    @DisplayName("자동차 경주에서 주어진 횟수 만큼 경주내역이 기록되는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,honux : 5", "pobi,crong,honux,test1,test2 : 7"}, delimiter = ':')
    void racingHistoryCheckTest(String inputName, int trialRaceCount) {
        String[] carNames = InputCarNameSplitUtils.getSplitStringArray(inputName);

        RacingInfo racingInfo = new RacingInfo(carNames.length, trialRaceCount);

        Cars cars = Cars.of(carNames);

        RacingGame racingGame = new RacingGame(racingInfo, cars);

        Board board = racingGame.gameStart(new RandomBoundMovingStrategy());

        assertThat(board.getAllRecords().size()).isEqualTo(trialRaceCount);
    }

    @DisplayName("자동차 경주에서 주어진 자동차 대수 만큼 경주하는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,honux : 5", "pobi,crong,honux,test1,test2 : 7"}, delimiter = ':')
    void racingCarsCountCheckTest(String inputName, int trialRaceCount) {
        String[] carNames = InputCarNameSplitUtils.getSplitStringArray(inputName);

        RacingInfo racingInfo = new RacingInfo(carNames.length, trialRaceCount);

        Cars cars = Cars.of(carNames);

        RacingGame racingGame = new RacingGame(racingInfo, cars);

        Board board = racingGame.gameStart(new RandomBoundMovingStrategy());

        assertThat(board.getAllRecords().get(0).size()).isEqualTo(racingInfo.numberOfCar);

    }

    @DisplayName("3명이 경기를 했다면 우승자는 최소 1명 이상 3명 이하의 우승자가 나오는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,honux : 5", "pobi,crong,honux,test1,test2 : 7"}, delimiter = ':')
    void racingWinnerTest(String inputName, int trialRaceCount) {

        String[] carNames = InputCarNameSplitUtils.getSplitStringArray(inputName);

        RacingInfo racingInfo = new RacingInfo(carNames.length, trialRaceCount);

        Cars cars = Cars.of(carNames);

        RacingGame racingGame = new RacingGame(racingInfo, cars);

        Board board = racingGame.gameStart(new RandomBoundMovingStrategy());

        board.record(Arrays.asList(carNames.clone()), Arrays.asList(5, 5, 5));

        List<String> winners = board.getWinnerCarsNames();

        assertThat(winners.size()).isBetween(1, carNames.length);

    }

}
