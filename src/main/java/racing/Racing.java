package racing;

import racing.input.InputView;
import racing.input.RaceInput;
import racing.race.Car;
import racing.race.RaceTrack;
import racing.race.RacingChecker;
import racing.result.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        RaceInput input = inputView.racingInput();

        List<Car> racingCars = racingCars(input.getNumOfCar());

        RaceTrack track = new RaceTrack(new RacingChecker());
        track.race(input, racingCars);

        ResultView resultView = new ResultView();
        resultView.result(input.getNumOfAttempt(), racingCars);
    }

    public static List<Car> racingCars(int numOfCar) {
        List<Car> racingCars = new ArrayList<>();

        for (int i = 0; i < numOfCar; i++) {
            racingCars.add(new Car());
        }
        return racingCars;
    }
}
