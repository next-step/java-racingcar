package step3;

import java.util.List;
import step3.domain.RacingHistories;
import step3.domain.RandomProceedPolicy;
import step3.ui.Cui;
import step3.service.PlayService;

public class RacingCarMainApp {

    public static void main(String[] args) {
        Cui cui = new Cui();
        PlayService playService = new PlayService(new RandomProceedPolicy());

        int carCount = cui.scanCarCount();
        int tryCount = cui.scanTryCount();

        List<String> racingHistories = playService.playRacingGame(carCount, tryCount);

        cui.printResult(racingHistories);
    }

}
