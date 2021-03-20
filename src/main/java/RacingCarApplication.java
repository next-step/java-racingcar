import step3.InputDto;
import step3.InputView;
import step3.RacingCar;
import step3.ResultView;

public class RacingCarApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        InputDto input = inputView.getInput();

        RacingCar racingCar = new RacingCar();
        racingCar.setInput(input);
        int[][] result = racingCar.getRandomValue();

        ResultView resultView = new ResultView();
        resultView.printResult(result, input);

    }
}
