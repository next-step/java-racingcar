package racingcar;

import racingcar.collection.RaceResult;
import racingcar.collection.RacingCarList;
import racingcar.collection.Race;
import racingcar.collection.Winners;
import racingcar.model.RacingGameRequest;
import racingcar.strategy.MoveStrategy;
import racingcar.strategy.RandomMoveStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final RacingCarList carList = new RacingCarList();
    private final int countOfTry;

    public RacingGame(RacingGameRequest request) {
        this.countOfTry = request.getCountOfTry();

        MoveStrategy moveStrategy = new RandomMoveStrategy();
        request.getCarNames()
                .forEach(carName ->
                        carList.participate(new Car(carName, moveStrategy)));
    }

    public RaceResult playRace() {
        RaceResult raceResult = new RaceResult();
        for (int i = 0; i < countOfTry; i++) {
            Race result = race();
            raceResult.addRaceResult(result);
        }
        raceResult.setWinners(getWinner());
        return raceResult;
    }

    private Winners getWinner() {
        List<Car> cars = this.carList.getCars();
        int maxPosition = cars.stream()
                .mapToInt(car ->
                        car.getCurrentPosition().getPosition())
                .max()
                .getAsInt();

        return new Winners(
                cars.stream()
                        .filter(car ->
                                car.getCurrentPosition()
                                        .getPosition() == maxPosition)
                        .collect(
                                Collectors.toList()));
    }

    private Race race() {
        Race race = new Race();
        carList.getCars().forEach(car -> {
            car.move();
            race.addResult(car);
        });

        return race;
    }
}
