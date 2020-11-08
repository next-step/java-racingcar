package step4;

import java.util.Scanner;

public class RacingCarUi {
    Scanner scanner = new Scanner(System.in);

    public String receiveRacerInput() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.next();
    }

    public int receiveMoveInput() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }

    public void resultWinnerPrint() {

    }

    public void close() {
        scanner.close();
    }
}
