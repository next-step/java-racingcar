package racinggame;

import racinggame.domain.Car;
import racinggame.domain.RacingResult;
import racinggame.service.CarAdvanceService;
import racinggame.service.RandomValueGeneratorImpl;
import racinggame.view.InputView;
import racinggame.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingGame {

    private Configuration configuration;

    private CarAdvanceService carAdvanceService = new CarAdvanceService(new RandomValueGeneratorImpl());

    public RacingGame(Configuration configuration) {
        this.configuration = configuration;
    }

    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        String[] carNames = inputView.getCarNames();
        Integer numberOfTries = inputView.getNumberOfTries();

        RacingGame racingGame = new RacingGame(new Configuration(carNames, numberOfTries));

        ResultView resultView = new ResultView();
        resultView.showResultTitle();

        RacingResult result = new RacingResult(racingGame.createCars());
        for( int i = 0; i < numberOfTries; ++i ) {
            racingGame.proceed(result);
            resultView.showCarPositions(result);
        }
        resultView.showWinners(result);
    }

    private List<Car> createCars() {
        List<Car> cars = new ArrayList<>();

        for( String name : configuration.getCarNames() ) {
            cars.add( new Car(name) );
        }

        return cars;
    }

    private void proceed(RacingResult result) {
        carAdvanceService.moveForward(result.getCars());
    }
}