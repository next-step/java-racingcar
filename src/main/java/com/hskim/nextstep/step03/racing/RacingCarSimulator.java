package com.hskim.nextstep.step03.racing;

import com.hskim.nextstep.step03.exception.ExceptionMessage;
import com.hskim.nextstep.step03.model.RacingCar;
import com.hskim.nextstep.step03.ui.ResultView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarSimulator {

    public static final int CAR_NAME_LIMIT = 5;
    private List<RacingCar> racingCarList;
    private int gameRepeatNum;

    public RacingCarSimulator() {

        racingCarList = Collections.emptyList();
        gameRepeatNum = 0;
    }

    public void setRacingCarList(String carNames) {

        racingCarList = Arrays.stream(carNames.split(","))
                .peek(this::validateCarName)
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }

    private void validateCarName(String carName) {

        if (carName.length() > CAR_NAME_LIMIT) {

            throw new IllegalArgumentException(ExceptionMessage.EXCEED_CAR_NAME_LENGTH.getExceptionMessage());
        }
    }

    public void setGameRepeatNum(int repeatNum) {

        gameRepeatNum = repeatNum;
    }

    public void simulate(ResultView resultView) {

        for (int index = 1; index <= gameRepeatNum; index++) {

            runGame(index, resultView);
        }
    }

    private void runGame(int gameNo, ResultView resultView) {

        resultView.printPhraseToConsole(" === GAME No." + gameNo + " ===");
        racingCarList.forEach(rc -> resultView.printPhraseToConsole(resultView.makeMoveProgressString(rc)));
        resultView.printPhraseToConsole("");
    }

    //getter
    public List<RacingCar> getRacingCarList() {
        return racingCarList;
    }

    public int getGameRepeatNum() {
        return gameRepeatNum;
    }
}
