package racingGame.participant;

import racingGame.car.Car;
import racingGame.game.MovingRule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    private final List<Car> cars;

    public Participants(String participates) {
        List<Car> carList = new ArrayList<>();
        String[] names = participates.split(",");
        for (String name : names) {
            carList.add(new Car(name));
        }
        this.cars = Collections.unmodifiableList(carList);
    }

    public Participants(List<Car> cars) {
        this.cars = Collections.unmodifiableList(cars);
    }

    public RoundScore startRound(MovingRule movingRule) {
        cars.forEach(car -> applyMovingRule(car, movingRule));
        return createRoundScore();
    }

    private void applyMovingRule(Car car, MovingRule carForwardRule) {
        if (carForwardRule.isMove()) {
            car.forward();
        }
    }

    private RoundScore createRoundScore() {
        return new RoundScore(cars.stream()
                .map(ParticipantScore::new)
                .collect(Collectors.toList()));
    }

    public List<Car> getWinners() {
        return getWinners(getWinnerPosition());
    }

    private List<Car> getWinners(int winnerPosition) {
        return cars.stream()
                .filter(car -> car.getPosition() == winnerPosition)
                .collect(Collectors.toList());
    }

    private int getWinnerPosition() {
        return cars.stream()
                .max(Comparator.comparing(Car::getPosition))
                .orElseThrow(IllegalArgumentException::new)
                .getPosition();
    }
}
