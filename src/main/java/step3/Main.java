package step3;

import java.util.List;

public class Main {

    private final static String EMPTY = "";
    public static void main(String[] args) {
        InputView inputView = new InputView();

        inputView.printCarCountInfo();
        int carCount = inputView.readInput();
        ValidationUtils.validateCarCount(carCount);

        inputView.printRoundTimeInfo();
        int roundTime = inputView.readInput();
        ValidationUtils.validateRoundTime(roundTime);

        RacingGame racingGame = new RacingGame();
        List<Car> carList = racingGame.play(carCount, roundTime);

        ResultView resultView = new ResultView();
        resultView.printResultInfo();

        for(int i = 0; i < roundTime; i++) {
            for(Car car: carList) {
                List<Round> roundList = car.getRoundInfoList();

                Round round = roundList.get(i);
                resultView.printResult(round.getPosition());
            }
            resultView.printView(EMPTY);
        }
    }
}
