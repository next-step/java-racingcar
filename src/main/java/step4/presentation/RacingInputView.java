package step4.presentation;

import step4.controller.CarController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RacingInputView {

    public static final String DELIMITER_OF_CAR_NAME = ",";

    private BufferedReader br;
    private CarController carController;

    public RacingInputView() {
    }

    public RacingInputView(CarController carController) {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.carController = carController;
    }

    public void inputNameOfCars() throws IOException {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        carController.createCarsOf(splitInputToNameOfCars());
    }

    private String[] splitInputToNameOfCars() throws IOException {
        return br.readLine().split(DELIMITER_OF_CAR_NAME);
    }

    public int inputNumOfTry() throws IOException {
        System.out.println("시도할 횟수는 몇 회 인가요?");

        return Integer.parseInt(br.readLine());
    }
}
