package step3;

import step3.controller.Input;
import step3.controller.InputController;
import step3.domain.Car;
import step3.domain.Contest;
import step3.movingstrategy.RandomMovingStrategy;
import step3.view.LocationReporter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleCarRacingGame {
    public static void main(String[] args) {
        Input input = new InputController().handleInput();

        LocationReporter reporter = new LocationReporter();

        List<Car> participants = Stream.generate(() -> new Car())
                .limit(input.getParticipantsNumber())
                .collect(Collectors.toList());
        int numOfRounds = input.numOfRounds();

        Contest contest = new Contest(numOfRounds, participants, new RandomMovingStrategy(), reporter);
        contest.play();
    }
}
