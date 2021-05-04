package racing;

import racing.controller.RacingController;
import racing.domain.MovableStrategy;
import racing.infra.RandomMovableStrategy;
import racing.infra.RandomNumberGenerator;
import racing.service.RacingService;
import racing.view.RacingResultScreen;
import racing.view.ReceivingRacingGameInput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MovableStrategy movableStrategy = RandomMovableStrategy.of(new RandomNumberGenerator());
        RacingService racingService = new RacingService(movableStrategy);
        RacingResultScreen racingResultScreen = new RacingResultScreen();
        ReceivingRacingGameInput receivingRacingGameInput = new ReceivingRacingGameInput(new Scanner(System.in));

        RacingController racingController = new RacingController(racingService, receivingRacingGameInput, racingResultScreen);

        racingController.play();
    }
}
