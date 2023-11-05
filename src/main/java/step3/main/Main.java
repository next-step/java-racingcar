package step3.main;

import step3.input.InputView;
import step3.input.UserInput;
import step3.racingcar.RacingCar;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //inputView
        final UserInput userInput = InputView.input();

        //게임 실행
        List<RacingCar> cars = new ArrayList<>();
        for (int i = 0; i < userInput.getCarNumber(); i++) {
            cars.add(RacingCar.build());
        }

        //resultView
    }
}
