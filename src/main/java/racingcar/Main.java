package racingcar;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        inputView.createInput();

        UserInput input = inputView.getInput();

        RacingGame game = new RacingGame(input.getCarNumber(), input.getRunNumber());
        List<RacingCycle> cycles = game.getCycles();

        ResultView resultView = new ResultView(cycles);
        resultView.print();
    }
}
