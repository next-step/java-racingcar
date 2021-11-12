package step3.view;

import step3.view.dto.InputDto;

import java.util.Scanner;

public class InputView {

    public static InputDto load() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carNumber = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int attemptNumber = scanner.nextInt();
        return InputDto.of(carNumber, attemptNumber);
    }
}