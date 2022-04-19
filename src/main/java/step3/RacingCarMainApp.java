package step3;

import java.util.List;
import java.util.Random;
import step3.domain.ProceedPolicy;
import step3.domain.RacingHistories;
import step3.service.PlayService;
import step3.view.Cui;
import step3.view.Ui;

public class RacingCarMainApp {
    public static final int POLICY_RANDOM_NUMBER = 4;
    private static final int RANDOM_BOUND = 10;

    public static final ProceedPolicy proceedPolicy = () -> {
        Random random = new Random();
        int randomInt = random.nextInt(RANDOM_BOUND);
        return randomInt >= POLICY_RANDOM_NUMBER;
    };

    public static void main(String[] args) {
        Ui userInterface = new Cui();
        PlayService playService = new PlayService(proceedPolicy);

        List<String> carNames = userInterface.inputCarNames();
        playService.createGame(carNames);

        int tryCount = userInterface.inputTryCount();

        RacingHistories racingHistories = playService.playRacingGame(tryCount);

        userInterface.showResult(racingHistories);
    }

}
