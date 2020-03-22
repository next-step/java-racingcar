package racingGame.participant;

import racingGame.car.Car;
import racingGame.game.RacingGameRule;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ParticipantsV2 implements Participants {
    private List<Car> cars;

    public ParticipantsV2(String participates) {
        List<Car> carList = new ArrayList<>();
        String[] names = participates.split(",");
        for (String name : names) {
            carList.add(new Car(name));
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
    public GameResult getGameResult() {
        return new GameResult(cars.stream()
                .map(CarRecord::new)
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
