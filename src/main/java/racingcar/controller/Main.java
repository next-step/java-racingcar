package racingcar.controller;

import racingcar.view.Input;
import racingcar.view.Output;

public class Main {
    public static void main(String[] args) {
        Output.printInputMessage("경주할 자동차 이름들");
        String carNames = Input.inputCarsName();

        Output.printInputMessage("시도할 횟수");
        int stages = Input.inputStages();

        RacingController racingController = new RacingController(carNames, stages);
        racingController.startRacing();
        racingController.endRacing();
    }
}