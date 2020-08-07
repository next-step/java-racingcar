package com.hskim.nextstep.step03.racing;

import com.hskim.nextstep.step03.exception.ExceptionMessage;
import com.hskim.nextstep.step03.model.MovableStrategy;
import com.hskim.nextstep.step03.model.Racing;
import com.hskim.nextstep.step03.model.RacingCar;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarSimulator {

    private static final int MOVE_DISTANCE_PER_GAME = 1;
    public static final String CAR_NAME_DELIMITER = ",";
    private List<RacingCar> racingCarList;
    private final int gameRepeatCount;
    private final List<Racing> racingHistory;
    private MovableStrategy movableStrategy;

    public RacingCarSimulator(List<String> carNameList, int gameRepeatCount, MovableStrategy movableStrategy) {

        setRacingCarList(carNameList);
        this.gameRepeatCount = gameRepeatCount;
        racingHistory = new LinkedList<>();
        this.movableStrategy = movableStrategy;
    }

    private void setRacingCarList(List<String> carNameList) {

        racingCarList = carNameList.stream()
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }

    public void simulate() {

        for (int index = 1; index <= gameRepeatCount; index++) {

            runGame(index);
        }
    }

    private void runGame(int gameNo) {

        Racing racing = new Racing(gameNo);

        racingCarList.forEach(racingCar -> {
            racingCar.moveForward(MOVE_DISTANCE_PER_GAME, movableStrategy);
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

    public List<Racing> getRacingHistory() {
        return racingHistory;
    }
}
