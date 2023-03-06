package car.controller;

import car.domain.Car;
import car.domain.Name;
import car.domain.Position;
import car.domain.RacingGame;
import car.ui.GameRequest;
import car.ui.GameResult;

import java.util.ArrayList;
import java.util.List;

public class RacingGameController {

    private final RacingGame game;

    public RacingGameController(RacingGame game) {
        this.game = game;
    }

    public GameResult play(String[] cars, int moveCount) {
        List<Car> participants = new ArrayList();
        validateParams(participants, cars, moveCount);
        GameRequest request = new GameRequest(participants, moveCount);
        game.play(request);

        return null;
    }

    private void validateParams(List<Car> participants, String[] cars, int moveCount) {
        validateMoveCount(moveCount);
        validateCarName(participants, cars);
    }

    private void validateCarName(List<Car> participants, String[] cars) {
        for (String name: cars) {
            participants.add(new Car(new Name(name), new Position(0)));
        }
    }

    private void validateMoveCount(int moveCount) {
        if (moveCount < 1) {
            throw new IllegalArgumentException("이동횟수는 1 이상이어야 합니다. moveCount: " + moveCount);
        }
    }
}
