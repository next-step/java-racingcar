package racing4.view;

import racing4.domain.Race4Command;

import java.util.Scanner;

public class InputView {
    public static Race4Command input() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] carNames = scanner.nextLine()
                                   .split(",");

        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = scanner.nextInt();

        return new Race4Command(carNames, tryCount);
    }
}
