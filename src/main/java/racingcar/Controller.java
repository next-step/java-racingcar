package racingcar;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Controller {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int cars = inputView.nextInt("자동차 대수는 몇 대 인가요?");
        int rounds = inputView.nextInt("시도할 회수는 몇 회 인가요?");
        inputView.close();

        RacingCar[] entries = new RacingCar[cars];
        Arrays.setAll(entries, entry -> new RacingCar());

        resultView.changeLines();
        resultView.printlnMessage("실행결과");

        IntStream.range(0, rounds).forEach(round -> {
            Arrays.stream(entries)
                    .peek(RacingCar::race)
                    .map(RacingCar::record)
                    .forEach(resultView::printlnLaps);
            resultView.changeLines();
        });
    }
}
