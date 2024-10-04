package racing.game;

import racing.car.CarFactory;
import racing.car.Cars;
import racing.view.InputView;
import racing.view.ResultHandler;
import racing.view.ResultView;

public class RacingGame {

    private final ResultHandler resultHandler;
    private final Winners winners;
    private final RacingRandomCalculator racingRandomCalculator;

    RacingGame(ResultHandler resultHandler, Winners winners, RacingRandomCalculator racingRandomCalculator) {
        this.resultHandler = resultHandler;
        this.winners = winners;
        this.racingRandomCalculator = racingRandomCalculator;
    }

    public static void main(String[] args) {
        InputView input = new InputView(); //입력
        String carName = input.carInput();
        int cycle = input.cntInput();

        Cars cars = new Cars(CarFactory.generateCars(carName));

        RacingRandomCalculator racingRandomCalculator = new RacingRandomCalculator();
        Winners winners = new Winners();
        ResultHandler resultHandler = new ResultView();
        RacingGame racingGame = new RacingGame(resultHandler, winners, racingRandomCalculator);

        racingGame.racingCycle(cars, cycle); //레이싱

        resultHandler.winnerPrint(winners.getWinners(cars));
    }

    /**
     * 주어진 사이클 동안 레이싱하는 기능
     */
    private void racingCycle(Cars cars, int cycle) {
        while (cycle > 0) {
            cycle--;
            cars.carGoAndStop(racingRandomCalculator);
            resultHandler.racingPrint(cars); //피드백 반영
        }
        resultHandler.endCycle();
    }

}
