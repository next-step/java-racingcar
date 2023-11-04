package me.namuhuchutong.step3;

public class RacingCar {

    public void start() {
        InputView inputView = new InputView();
        UserInputInformation userInputInformation = new UserInputInformation();
        userInputInformation.setNumberOfCars(inputView.showPrompt("자동차 수를 입력하세요."));
        userInputInformation.setTimes(inputView.showPrompt("경주 횟수를 입력하세요."));

        RacingService racingService = new RacingService();
        RacingResult racingResult = racingService.runRacing(userInputInformation);

        OutputView outputView = new OutputView();
        outputView.printResult(racingResult);
    }
}
