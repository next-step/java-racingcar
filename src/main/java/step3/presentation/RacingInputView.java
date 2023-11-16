package step3.presentation;

import step3.controller.CarController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RacingInputView {

    private BufferedReader br;
    private CarController carController;

    public RacingInputView() {
    }

    public RacingInputView(CarController carController) {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.carController = carController;
    }

    public void inputNumOfCars() throws IOException {
        System.out.println("자동차 대수는 몇 대 인가요?");

        carController.createCarsOf(Integer.parseInt(br.readLine()));
    }

    public int inputNumOfTry() throws IOException {
        System.out.println("시도할 횟수는 몇 회 인가요?");

        return Integer.parseInt(br.readLine());
    }
}
