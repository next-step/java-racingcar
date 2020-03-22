package racingGame.participant;

import racingGame.car.Car;
import racingGame.game.RacingGameRule;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FakeParticipants implements Participants {
    private List<Car> cars;

    public FakeParticipants(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public RoundScore startRound(RacingGameRule carForwardRule) {
        cars.forEach(car -> checkCarForwardRule(car, carForwardRule));
        return new RoundScore(cars.stream()
                .map(ParticipantScore::new)
                .collect(Collectors.toList()));
    }

    private void checkCarForwardRule(Car car, RacingGameRule carForwardRule) {
        if (carForwardRule.result()) {
            car.forward();
        }
    }

    @Override
    public List<Car> getWinners() {
        int winnerPosition = cars.stream()
                .max(Comparator.comparing(Car::getPosition))
                .get().getPosition();

        return cars.stream()
                .filter(car -> car.getPosition() == winnerPosition)
                .collect(Collectors.toList());
    }
}
