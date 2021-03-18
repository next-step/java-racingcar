package step4;

import step4.dto.InputDto;
import step4.view.InputView;

public class Main {
    public static void main(String[] args) {
        try {
            InputDto inputDto = InputView.input();
            RacingCar racingCar = new RacingCar(inputDto);
            racingCar.start();
        } catch (IllegalArgumentException e) {
            System.out.println("어떤 에러 일까요? -> " + e);
        }
    }
}
