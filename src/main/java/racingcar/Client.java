package racingcar;

import java.util.*;

public class Client {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        int carsNum = inputView.carsNumView();
        int gameCount = inputView.gameCountView();

        Racing racing = new Racing(carsNum, gameCount);
        racing.race();

        ResultView resultView = new ResultView();
        resultView.printResult(racing);

    }

}
