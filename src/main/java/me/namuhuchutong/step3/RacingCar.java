package me.namuhuchutong.step3;

public class RacingCar {

    public static final String HOW_MANY_CARS = "자동차 수를 입력하세요.";
    public static final String HOW_MANY_TIMES = "경주 횟수를 입력하세요.";

    public void start() {
        InputView inputView = new InputView();
        UserInputInformation userInputInformation = new UserInputInformation();
        userInputInformation.setNumberOfCars(inputView.showPrompt(HOW_MANY_CARS));
        userInputInformation.setTimes(inputView.showPrompt(HOW_MANY_TIMES));

        RacingService racingService = new RacingService();
        RacingResult racingResult = racingService.runRacing(userInputInformation);

        OutputView outputView = new OutputView();
        outputView.printResult(racingResult);
    }
}
