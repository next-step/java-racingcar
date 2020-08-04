package com.hskim.nextstep.step03.racing;

import com.hskim.nextstep.step02.utils.StringUtils;
import com.hskim.nextstep.step03.model.RacingCar;
import com.hskim.nextstep.step03.ui.ResultView;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCarSimulator {

    private List<RacingCar> racingCarList;
    private int gameRepeatNum;

    public RacingCarSimulator() {

        racingCarList = Collections.emptyList();
        gameRepeatNum = 0;
    }

    public void setRacingCarList(int carNum) {

        racingCarList = IntStream.rangeClosed(1, carNum)
                .boxed()
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }

    public void setGameRepeatNum(int repeatNum) {

        gameRepeatNum = repeatNum;
    }

    public void simulate(ResultView resultView) {

        for(int index = 1 ; index <= gameRepeatNum ; index++){

            runGame(index, resultView);
        }
    }

    private void runGame(int gameNo, ResultView resultView) {

        resultView.printPhraseToConsole(" === GAME No."+gameNo+" ===");
        racingCarList.forEach(rc -> resultView.printPhraseToConsole(makeMoveProgressString(rc)));
        resultView.printPhraseToConsole("");
    }

    private String makeMoveProgressString(RacingCar racingCar) {

        return new StringBuilder()
                .append(racingCar.getCarNo())
                .append(". ")
                .append(StringUtils.repeat("-", racingCar.moveForward(1)))
                .toString();
    }

    //getter
    public List<RacingCar> getRacingCarList() {
        return racingCarList;
    }

    public int getGameRepeatNum() {
        return gameRepeatNum;
    }
}
