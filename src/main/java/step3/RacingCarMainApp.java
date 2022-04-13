package step3;

import java.util.List;
import step3.domain.RacingHistories;
import step3.domain.RandomProceedPolicy;
import step3.service.PlayService;
import step3.ui.Cui;
import step3.ui.Ui;

public class RacingCarMainApp {

    public static void main(String[] args) {
        Ui userInterface = new Cui();
        PlayService playService = new PlayService(new RandomProceedPolicy());

        List<String> carNames = userInterface.inputCarNames();
        try {
            playService.createGame(carNames);
        } catch (IllegalArgumentException e) {
            System.err.println("차 이름 길이는 5 초과 불가");
            System.exit(e.hashCode());
        }

        int tryCount = userInterface.inputTryCount();

        RacingHistories racingHistories = playService.playRacingGame(tryCount);

        userInterface.showResult(racingHistories);
    }

}
