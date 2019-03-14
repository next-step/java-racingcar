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

    private List<Car> carList = new ArrayList<>();

    private RacingGameConfiguration configuration;

    public RacingGame(RacingGameConfiguration configuration) {
        this.configuration = configuration;
    }

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(new InputView(new Scanner(System.in)).getConfiguration());
        racingGame.initializeCarList();

        ResultView resultView = new ResultView();
        racingGame.proceed(resultView);
        racingGame.showWinners(resultView);
    }

    private void initializeCarList() {
        for( String name : configuration.getCarNames() ) {
            carList.add( new Car(name) );
        }
    }

    private void proceed(ResultView resultView) {
        CarAdvanceService carAdvanceService = new CarAdvanceService(new RandomValueGeneratorImpl());

        resultView.showResultTitle();
        resultView.showCarPositions(carList);
        for( int i = 0, numberOfTries = configuration.getNumberOfTries(); i < numberOfTries; ++i ) {
            carAdvanceService.moveForward(carList);
            resultView.showCarPositions(carList);
        }
    }

    private void showWinners(ResultView resultView) {
        WinnerDecisionService winnerDecisionService = new WinnerDecisionService();
        List<Car> winnerList = winnerDecisionService.getWinnerList(carList);
        resultView.showWinners(winnerList);
    }

}