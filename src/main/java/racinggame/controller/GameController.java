package racinggame.controller;

import racinggame.domain.entity.Car;
import racinggame.domain.entity.Contest;
import racinggame.domain.entity.Participants;
import racinggame.domain.movingstrategy.MovingStrategy;
import racinggame.domain.value.Input;
import racinggame.view.LocationView;
import racinggame.view.WinnerView;

import java.util.List;

public class GameController {
    private final LocationView locationView;
    private final WinnerView winnerView;
    private final MovingStrategy movingStrategy;

    public GameController(LocationView locationView, WinnerView winnerView, MovingStrategy movingStrategy) {
        this.locationView = locationView;
        this.winnerView = winnerView;
        this.movingStrategy = movingStrategy;
    }

    public void run(Input input) {
        List<Car> cars = input.getParticipantsAsCar();
        Participants participants = new Participants(cars);
        int numOfRounds = input.getNumOfRounds();

        Contest contest = new Contest(numOfRounds, participants, movingStrategy, locationView, winnerView);
        contest.play();
    }
}
