package racing.controller;

import racing.service.RacingResult;
import racing.service.RacingService;
import racing.view.RacingResultScreen;
import racing.view.ReceivingRacingGameInput;

public class RacingController {
    private final RacingService racingService;
    private final ReceivingRacingGameInput receivingRacingGameInput;
    private final RacingResultScreen racingResultScreen;

    public RacingController(RacingService racingService, ReceivingRacingGameInput receivingRacingGameInput,
                            RacingResultScreen racingResultScreen) {
        this.racingService = racingService;
        this.receivingRacingGameInput = receivingRacingGameInput;
        this.racingResultScreen = racingResultScreen;
    }

    public void play() {
        String carNames = receivingRacingGameInput.receiveCarNames();
        int roundNumber = receivingRacingGameInput.receiveRoundNumber();
        race(carNames, roundNumber);
    }

    private void race(String carNames, int roundNumber) {
        try {
            RacingResult racingResult = racingService.race(carNames, roundNumber);
            racingResultScreen.print(racingResult);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException);
            play();
        }
    }
}
