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
        playService.createGame(carNames);

        int tryCount = userInterface.inputTryCount();

        RacingHistories racingHistories = playService.playRacingGame(tryCount);

        userInterface.showResult(racingHistories);
    }

}
