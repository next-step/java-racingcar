package racinggame;

import racinggame.domain.Car;
import racinggame.service.CarAdvanceService;
import racinggame.service.RandomValueGeneratorImpl;
import racinggame.service.WinnerDecisionService;
import racinggame.view.InputView;
import racinggame.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingGame {

    private List<Car> cars = new ArrayList<>();

    private Configuration configuration;

    public RacingGame(Configuration configuration) {
        this.configuration = configuration;
        initializeCarList();
    }

    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        String[] carNames = inputView.getCarNames();
        Integer numberOfTries = inputView.getNumberOfTries();

        RacingGame racingGame = new RacingGame(new Configuration(carNames, numberOfTries));

        ResultView resultView = new ResultView();
        racingGame.proceed(resultView);
        racingGame.showWinners(resultView);
    }

    private void initializeCarList() {
        for( String name : configuration.getCarNames() ) {
            cars.add( new Car(name) );
        }
    }

    private void proceed(ResultView resultView) {
        CarAdvanceService carAdvanceService = new CarAdvanceService(new RandomValueGeneratorImpl());

        resultView.showResultTitle();
        resultView.showCarPositions(cars);
        for( int i = 0, numberOfTries = configuration.getNumberOfTries(); i < numberOfTries; ++i ) {
            carAdvanceService.moveForward(cars);
            resultView.showCarPositions(cars);
        }
    }

    private void showWinners(ResultView resultView) {
        List<Car> winnerList = WinnerDecisionService.getWinnerList(cars);
        resultView.showWinners(winnerList);
    }

}