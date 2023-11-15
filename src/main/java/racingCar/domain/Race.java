package racingCar.domain;

import java.util.List;
import java.util.Random;

import racingCar.view.InputView;
import racingCar.view.ResultView;

public class Race {
    private static final int MAX_RANDOM_NUMBER = 10;
    private List<Car> racingCars;
    private int numberOfRace;

    private final Random random = new Random();

    public static void main(String[] args) {
        Race race = new Race();
        race.raceStart();
    }

    public Race() {
        prepareRace();
    }

    private void prepareRace() {
        CarFactory carFactory = new CarFactory();
        List<CarName> carNames = CarNameSplitter.names(InputView.carNames());
        this.racingCars = carFactory.makeCars(carNames);
        this.numberOfRace = InputView.numberOfRace();
    }

    public void raceStart() {
        ResultView.executionResultSign();
        for (int i = 0; i < this.numberOfRace; i++) {
            singleRace();
        }
        ResultView.announceWinner(Referee.findWinners(this.racingCars));
    }

    private void singleRace() {
        for (int i = 0; i < this.racingCars.size(); i++) {
            Car car = racingCars.get(i);
            car.moveForward(randomNumber());
            ResultView.showDistance(car);
        }
        ResultView.showNextRound();
    }

    private int randomNumber() {
        return random.nextInt(MAX_RANDOM_NUMBER);
    }
}
