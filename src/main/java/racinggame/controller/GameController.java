package racinggame.controller;

import racinggame.domain.entity.Car;
import racinggame.domain.entity.Contest;
import racinggame.domain.entity.Participants;
import racinggame.domain.movingstrategy.MovingStrategy;
import racinggame.domain.value.Input;
import racinggame.view.LocationView;

import java.util.List;

public class GameController {
    private final LocationView view;
    private final MovingStrategy movingStrategy;

    public GameController(LocationView view, MovingStrategy movingStrategy) {
        this.view = view;
        this.movingStrategy = movingStrategy;
    }

    public void run(Input input) {
        List<Car> cars = input.getParticipantsAsCar();
        Participants participants = new Participants(cars);
        int numOfRounds = input.getNumOfRounds();

        Contest contest = new Contest(numOfRounds, participants, movingStrategy, view);
        contest.play();
    }
}
