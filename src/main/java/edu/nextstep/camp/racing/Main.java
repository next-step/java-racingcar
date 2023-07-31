package edu.nextstep.camp.racing;

import edu.nextstep.camp.racing.controller.RacingController;
import edu.nextstep.camp.racing.domain.Cars;
import edu.nextstep.camp.racing.view.ConsoleRacingInputView;
import edu.nextstep.camp.racing.view.ConsoleRacingOutputView;

public class Main {
    public static void main(String[] args) {
        try {
            RacingController racingController = new RacingController(new ConsoleRacingInputView(), new ConsoleRacingOutputView());

            Cars cars = racingController.inputCars();
            racingController.start(cars);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
