package racingGame.participant;

import racingGame.car.Car;
import racingGame.game.RacingGameRule;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ParticipantsV1 implements Participants {
    private List<Car> cars;

    public ParticipantsV1(int participates) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < participates; i++) {
            carList.add(new Car("V1에는 이름이 없었다고 한다"));
        }
        cars = carList;
    }

    @Override
    public void gameStart(RacingGameRule carForwardRule) {
        cars.forEach(car -> checkCarForwardRule(car, carForwardRule));
    }

    private void checkCarForwardRule(Car car, RacingGameRule carForwardRule) {
        if (carForwardRule.result()) {
            car.forward();
        }
    }

    @Override
    public RoundScore getRoundScore() {
        return new RoundScore(cars.stream()
                .map(CarScore::new)
                .collect(Collectors.toList()));
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
