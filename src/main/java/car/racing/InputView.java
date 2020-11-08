package car.racing;

import java.util.Scanner;

public class InputView {

    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String names = scanner.next();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCount = scanner.nextInt();

        CarRacingFactory.newInstance(names).input(tryCount);
    }
}
