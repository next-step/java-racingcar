package com.hskim.nextstep.step03.racing;

import com.hskim.nextstep.step03.exception.ExceptionMessage;
import com.hskim.nextstep.step03.model.RacingCar;
import com.hskim.nextstep.step03.ui.ResultView;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingCarSimulator {

    public static final String CAR_NAME_DELIMITER = ",";
    private List<RacingCar> racingCarList;
    private int gameRepeatNum;

    public RacingCarSimulator() {

        racingCarList = Collections.emptyList();
        gameRepeatNum = 0;
    }

    public void setRacingCarList(List<String> carNameList) {

        racingCarList = carNameList.stream()
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }

    public void setGameRepeatNum(int repeatNum) {

        gameRepeatNum = repeatNum;
    }

    public void simulate(ResultView resultView) {

        for (int index = 1; index <= gameRepeatNum; index++) {

            runGame(index, resultView);
        }

        resultView.printPhraseToConsole(findWinners() + "가 최종 우승했습니다.");
    }

    private void runGame(int gameNo, ResultView resultView) {

        resultView.printPhraseToConsole(" === GAME No." + gameNo + " ===");
        racingCarList.forEach(rc -> resultView.printPhraseToConsole(resultView.makeMoveProgressString(rc)));
        resultView.printPhraseToConsole("");
    }

    private String findWinners() {

        int winnerTotalDistance = racingCarList.stream()
                .map(RacingCar::getTotalMovedDistance)
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalStateException(ExceptionMessage.FAIL_TO_FIND_WINNER.getExceptionMessage()));

        return racingCarList.stream()
                .filter(racingCar -> racingCar.getTotalMovedDistance() == winnerTotalDistance)
                .map(RacingCar::getCarName)
                .collect(Collectors.joining(", "));
    }

    //getter
    public List<RacingCar> getRacingCarList() {
        return racingCarList;
    }

    public int getGameRepeatNum() {
        return gameRepeatNum;
    }
}
