package racing;

import racing.domain.CarGame;
import racing.domain.RandomStrategy;
import racing.domain.RoundRecord;
import racing.view.ResultView;

import java.util.List;

import static racing.view.InputView.inputCarCount;
import static racing.view.InputView.inputGameCount;

public class Application {
    public static void main(String[] args) {
        //입력부
        int participants = inputCarCount();
        int rounds = inputGameCount();
        // 로직 실행부
        CarGame carGame = new CarGame(participants, rounds, new RandomStrategy());
        List<RoundRecord> roundRecords = carGame.start();
        // 출력부
        ResultView.showResult(roundRecords);
    }
}
