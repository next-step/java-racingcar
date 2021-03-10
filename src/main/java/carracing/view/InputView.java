package carracing.view;

import carracing.controller.dto.CarRacingRequest;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public CarRacingRequest inputRequest() {
        CarRacingRequest carRacingRequest = new CarRacingRequest();
        carRacingRequest.setRacingCarCount(this.inputRacingCarCount());
        carRacingRequest.setRoundCount(this.inputRacingCount());

        return carRacingRequest;
    }

    private int inputRacingCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    private int inputRacingCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
