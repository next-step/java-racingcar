package step3;

import step3.domain.entity.Car;
import step3.domain.entity.Contest;
import step3.domain.entity.Participants;
import step3.domain.movingstrategy.RandomMovingStrategy;
import step3.domain.value.Input;
import step3.view.InputView;
import step3.view.LocationView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleCarRacingGame {
    public static void main(String[] args) {
        InputView view = new InputView();
        view.render();
        Input input = view.readInput();

        LocationView reporter = new LocationView();

        List<Car> participants = Stream.generate(Car::new)
                .limit(input.getParticipantsNumber())
                .collect(Collectors.toList());
        int numOfRounds = input.numOfRounds();

        Contest contest = new Contest(numOfRounds, new Participants(participants), new RandomMovingStrategy(), reporter);
        contest.play();
    }
}
