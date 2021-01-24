package racingcar.controller;

import racingcar.di.CarFactory;
import racingcar.di.CarFactoryImpl;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.utils.NameChecker;
import racingcar.utils.NameCheckerImpl;
import racingcar.utils.RacingTrack;
import racingcar.utils.RacingTrackImpl;
import racingcar.view.RacingGameView;
import racingcar.view.RacingGameViewImpl;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameControllerImpl implements RacingGameController {
    private final RacingGameView racingGameView = new RacingGameViewImpl();
    private final Cars cars = new Cars();
    private final CarFactory carFactory = new CarFactoryImpl();
    private final RacingTrack racingTrack = new RacingTrackImpl();
    private final NameChecker nameChecker = new NameCheckerImpl();

    @Override
    public void initialize() {
        String[] carNames = racingGameView.inputCarNames();
        try {
            List<Car> newCars = carFactory.makeCars(carNames)
                    .stream()
                    .filter(car -> nameChecker.checkAvailableCarName(car.getName()))
                    .collect(Collectors.toList());

            cars.addAll(newCars);
        } catch (Exception exception) {
            initialize();
        }
    }

    @Override
    public void play() {
        int playCount = racingGameView.inputPlayCount();
        racingTrack.run(playCount, () -> {
            cars.move();
            racingGameView.printCarsPosition(cars.getList());
        });
    }

    @Override
    public void showResult() {
        List<Car> topRankers = cars.pickTopRankers();
        racingGameView.printWinner(topRankers);
    }
}