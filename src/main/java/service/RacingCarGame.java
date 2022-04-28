package service;

import dto.RacingHistoryDto;
import model.Cars;
import model.MoveCount;
import model.RandomMoveRule;
import model.RoundHistory;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    public static RacingCarGame instance = new RacingCarGame();

    private RacingCarGame() {

    }

    public static RacingCarGame getInstance() {
        return instance;
    }

    public RacingHistoryDto race(Cars cars, MoveCount moveCount) {
        List<RoundHistory> roundHistories = new ArrayList<>();

        while (!moveCount.isDone()) {
            moveCount.decreaseMoveCount();
            cars.moveCars(new RandomMoveRule());
            roundHistories.add(new RoundHistory(cars.getMoveHistories()));
        }

        return new RacingHistoryDto(cars.getWinnerCarNames(), roundHistories);
    }

}
