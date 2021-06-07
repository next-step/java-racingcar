package racing.view;

import java.util.Scanner;

public class InputView {
    Scanner scan = new Scanner(System.in);

    public String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = scan.nextLine();

        return carNames;
    }

    public int getTryNo() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryNo = scan.nextInt();

        return tryNo;
    }
}
