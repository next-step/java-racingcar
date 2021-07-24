package racingcar.view;

import racingcar.controller.dto.CarRequestDto;

import java.util.Scanner;

public class ConsoleInputView {

    public CarRequestDto input() {
        Scanner scanner = new Scanner(System.in);
        String names = enterOfName(scanner);
        String numberOfAttempts = enterNumberOfAttempts(scanner);
        return new CarRequestDto(names, numberOfAttempts);
    }

    private String enterNumberOfAttempts(Scanner scanner) {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextLine();
    }

    private String enterOfName(Scanner scanner) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }
}
