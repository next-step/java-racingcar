package step3.controller;

import step3.domain.entity.Car;
import step3.domain.entity.Contest;
import step3.domain.entity.Participants;
import step3.domain.movingstrategy.MovingStrategy;
import step3.domain.value.Input;
import step3.view.LocationView;

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
