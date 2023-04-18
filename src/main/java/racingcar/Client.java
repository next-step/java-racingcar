package racingcar;

import java.util.List;

public class Client {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        List<String> carsNames = inputView.carsNameView();
        int gameCount = inputView.gameCountView();

        Racing racing = new Racing(carsNames, gameCount);
        racing.race();

        ResultView resultView = new ResultView();
        resultView.printResult(racing);

    }

}
