package study.step_4;


import study.step_4.service.RacingCar;
import study.step_4.ui.InputView;
import study.step_4.ui.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    private final int DEFAULT_DISTANCE = 0;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public List<RacingCar> setUpRacingCar(String[] numberOfCars) {
        ArrayList<RacingCar> garage = new ArrayList<>();
        for (String numberOfCar : numberOfCars) {
            garage.add(new RacingCar(numberOfCar, DEFAULT_DISTANCE));
        }
        return garage;
    }

    public static void main(String[] args) {
        RacingCarGame game = new RacingCarGame(new InputView(), new OutputView());
    }
}
