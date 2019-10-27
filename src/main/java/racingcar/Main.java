package racingcar;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        UserInput input = new InputView().getInput();

        RacingGame game = new RacingGame(input.getCarNumber(), input.getRunNumber());
        List<RacingCycle> cycles = game.getCycles();

        ResultView resultView = new ResultView(cycles);
        resultView.print();
    }
}
