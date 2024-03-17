package racing;

import racing.domain.CarGame;
import racing.domain.RandomStrategy;
import racing.domain.RoundRecords;
import racing.view.ResultView;

import static racing.view.InputView.inputGameCount;
import static racing.view.InputView.inputPalyersName;

public class Application {
    public static void main(String[] args) {
        //입력부
        String[] names = inputPalyersName();
        int rounds = inputGameCount();

        // 로직 실행부
        CarGame carGame = new CarGame(rounds, new RandomStrategy(), names);
        RoundRecords roundRecords = carGame.start();
        // 출력부
        ResultView.showResult(roundRecords);
    }
}
