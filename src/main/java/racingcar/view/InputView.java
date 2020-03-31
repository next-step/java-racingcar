package racingcar.view;

import racingcar.dto.RacingCarRequestDto;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputRacingCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public static int inputRacingGameTimes() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    public static RacingCarRequestDto inputParams() {
        return new RacingCarRequestDto(inputRacingCars(), inputRacingGameTimes());
    }
}
