import java.util.Scanner;

public class RacingGame {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int carCount = inputView.promptInt("자동차 대수는 몇 대 인가요?");
        int tryCount = inputView.promptInt("시도할 회수는 몇 회 인가요?");

        ResultView resultView = new ResultView();
        resultView.present("");
    }
}
