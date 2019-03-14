package racinggame;

import racinggame.service.CarAdvanceService;
import racinggame.service.WinnerDecisionService;
import util.StringUtils;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private List<Car> carList;

    private RacingGameConfiguration configuration;

    public RacingGame(RacingGameConfiguration configuration) {
        this.configuration = configuration;
    }

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(InputView.getConfiguration());
        racingGame.initializeCarPositions();

        CarAdvanceService carAdvanceService = new CarAdvanceService(new Random());
        ResultView resultView = new ResultView();

        racingGame.showGame(carAdvanceService, resultView);

        WinnerDecisionService winnerDecisionService = new WinnerDecisionService(racingGame.carList);
        resultView.showWinners(winnerDecisionService.getWinners());
    }

    private void initializeCarPositions() {

        carList = new ArrayList<>();

        if( StringUtils.isArrayNullOrEmpty(configuration.getCarNames()) ) {
            return;
        }

        for( String name : configuration.getCarNames() ) {
            carList.add( new Car( name, 1 ) );
        }
    }

    private void showGame(CarAdvanceService service, ResultView resultView) {
        resultView.showCarPositions(carList);

        for( int i = 0, numberOfTries = configuration.getNumberOfTries(); i < numberOfTries; ++i ) {
            service.moveForward(carList);
        }
    }

}