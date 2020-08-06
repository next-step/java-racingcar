package com.hskim.nextstep.step03.racing;

import com.hskim.nextstep.step03.exception.ExceptionMessage;
import com.hskim.nextstep.step03.model.Racing;
import com.hskim.nextstep.step03.model.RacingCar;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarSimulator {

    private static final int MOVE_DISTANCE_PER_GAME = 1;
    public static final String CAR_NAME_DELIMITER = ",";
    private List<RacingCar> racingCarList;
    private int gameRepeatNum;
    private List<Racing> racingHistory;

    public RacingCarSimulator() {

        racingCarList = Collections.emptyList();
        gameRepeatNum = 0;
        racingHistory = new LinkedList<>();
    }

    public void setRacingCarList(List<String> carNameList) {

        racingCarList = carNameList.stream()
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }

    public void setGameRepeatNum(int repeatNum) {

        gameRepeatNum = repeatNum;
    }

    public void simulate() {

        for (int index = 1; index <= gameRepeatNum; index++) {

            runGame(index);
        }
    }

    private void runGame(int gameNo) {

        Racing racing = new Racing(gameNo);

        racingCarList.forEach(racingCar -> {
            racingCar.moveForward(MOVE_DISTANCE_PER_GAME);
            racing.addRecord(racingCar);
        });

        racingHistory.add(racing);
    }

    public List<RacingCar> findWinners() {

        int winnerTotalDistance = racingCarList.stream()
                .map(RacingCar::getTotalMovedDistance)
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalStateException(ExceptionMessage.FAIL_TO_FIND_WINNER.getExceptionMessage()));

        return racingCarList.stream()
                .filter(racingCar -> racingCar.getTotalMovedDistance() == winnerTotalDistance)
                .collect(Collectors.toList());
    }

    //getter
    public List<RacingCar> getRacingCarList() {
        return racingCarList;
    }

    public List<Racing> getRacingHistory() {
        return racingHistory;
    }
}
