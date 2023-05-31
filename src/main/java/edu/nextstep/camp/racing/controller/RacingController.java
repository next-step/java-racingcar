package edu.nextstep.camp.racing.controller;

import edu.nextstep.camp.racing.io.InputView;
import edu.nextstep.camp.racing.io.OutputView;
import edu.nextstep.camp.racing.model.RacingResult;
import edu.nextstep.camp.racing.model.RacingStartInput;
import edu.nextstep.camp.racing.service.RacingService;

import static edu.nextstep.camp.racing.io.InputView.input;
import static edu.nextstep.camp.racing.io.OutputView.*;

public class RacingController {

    private final RacingService racingService;

    public RacingController(RacingService racingService) {
        this.racingService = racingService;
    }

    public void start(){
        try {
            RacingStartInput racingStartInput = racingStartInput();

            RacingResult result = racingService.startRace(racingStartInput);

            print(result.toString());
        } catch (RuntimeException e){
            print(e.getMessage());
            start();
        }
    }

    private RacingStartInput racingStartInput(){
        return new RacingStartInput(
                answerVehicleCount(),
                answerMovingCount()
        );
    }

    private String answerVehicleCount(){
        printAnswerVehicleCount();
        return input();
    }

    private String answerMovingCount(){
        printAnswerMovingCount();
        return input();
    }
}
