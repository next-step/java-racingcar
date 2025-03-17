import java.util.Random;

public class Game {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int carCount = inputView.promptInt("자동차 대수는 몇 대 인가요?");
        int roundCount = inputView.promptInt("시도할 회수는 몇 회 인가요?");

        Race race = new Race(carCount, roundCount);

        ResultView resultView = new ResultView();
        resultView.present("실행 결과");
    }
}
