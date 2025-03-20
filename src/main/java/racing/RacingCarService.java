package racing;

import java.util.List;

public class RacingCarService {

    String[] carNames;
    private int numberOfLaps;


    public void start() {
        inputRacingData();
        List<Car> winners = startRacing();
        ResultView.displayWinners(winners);
    }

    private void inputRacingData() {
        carNames = InputView.getCarNames();
        numberOfLaps = InputView.getNumberOfLaps();
    }

    private List<Car> startRacing() {
        List<Car> cars = CarFactory.createRacingCars(carNames);
        Race race = new Race(cars, numberOfLaps);
        return race.startRacingAndReturnWinner();
    }
}
