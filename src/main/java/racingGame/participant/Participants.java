package racingGame.participant;

import racingGame.car.Car;
import racingGame.game.RacingGameRule;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    private List<Car> cars;

    public Participants(String participates) {
        List<Car> carList = new ArrayList<>();
        String[] names = participates.split(",");
        for (String name : names) {
            carList.add(new Car(name));
        }
        new Participants(carList);
    }

    public Participants(List<Car> cars) {
        this.cars = cars;
    }

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

    public List<Car> getWinners() {
        int winnerPosition = cars.stream()
                .max(Comparator.comparing(Car::getPosition))
                .orElseThrow(IllegalArgumentException::new)
                .getPosition();

        return cars.stream()
                .filter(car -> car.getPosition() == winnerPosition)
                .collect(Collectors.toList());
    }
}
