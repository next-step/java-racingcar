package carracing.view;

import carracing.controller.dto.CarRacingRequest;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public CarRacingRequest inputRequest() {
        return new CarRacingRequest(inputRacingCarNames(), inputRacingCount());
    }

    private String inputRacingCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.next();
    }

    private int inputRacingCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
