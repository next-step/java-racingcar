package me.namuhuchutong.step4.controller;

import me.namuhuchutong.step4.domain.RacingCarService;
import me.namuhuchutong.step4.dto.RacingResult;
import me.namuhuchutong.step4.dto.UserInputInformation;
import me.namuhuchutong.step4.view.InputView;
import me.namuhuchutong.step4.view.OutputView;

public class RacingCar {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingCarService racingCarService;

    public RacingCar(InputView inputView, OutputView outputView, RacingCarService racingCarService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingCarService = racingCarService;
    }

    public void start() {
        UserInputInterceptor userInputInterceptor = new UserInputInterceptor();
        UserInputInformation userInputInformation = userInputInterceptor.handleUserInput(inputView.showPrompt());
        RacingResult racingResult = racingCarService.runRacing(userInputInformation);
        outputView.printResult(racingResult);
    }
}
