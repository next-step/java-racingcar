package racingcar.view;

import racingcar.controller.dto.CarRequestDto;

import java.util.Scanner;

public class ConsoleInputView {

    public CarRequestDto input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        String numberOfCars = scanner.nextLine();
        System.out.println("시도할 회수는 몇 회 인가요?");
        String numberOfAttempts = scanner.nextLine();

        return new CarRequestDto(numberOfCars, numberOfAttempts);
    }
}
