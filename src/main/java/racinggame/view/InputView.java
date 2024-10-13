package racinggame.view;

import java.util.Scanner;
import racinggame.dto.InputDto;

public class InputView {

    public static InputDto readCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = scanner.next();
        int repeat = readCount("시도할 회수는 몇 회 인가요?", scanner);
        return new InputDto(carNames, repeat);
    }

    private static int readCount(String message, Scanner scanner) {
        System.out.println(message);
        return scanner.nextInt();
    }

}
