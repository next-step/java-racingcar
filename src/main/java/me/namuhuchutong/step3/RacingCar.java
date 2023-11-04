package me.namuhuchutong.step3;

public class RacingCar {

    public static final String HOW_MANY_CARS = "자동차 수를 입력하세요.";
    public static final String HOW_MANY_TIMES = "경주 횟수를 입력하세요.";

     private final RacingService racingService;
     private final InputView inputView;
     private final OutputView outputView;

    public RacingCar(RacingService racingService, InputView inputView, OutputView outputView) {
        this.racingService = racingService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        UserInputInformation userInputInformation = new UserInputInformation();
        userInputInformation.setNumberOfCars(inputView.showPrompt(HOW_MANY_CARS));
        userInputInformation.setTimes(inputView.showPrompt(HOW_MANY_TIMES));
        RacingResult racingResult = racingService.runRacing(userInputInformation);
        outputView.printResult(racingResult);
    }
}
