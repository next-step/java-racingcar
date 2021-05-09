package car;

import java.util.Scanner;

public class Input {

    public String carNameinput() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(\\,)를 기준으로 구분)");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String countInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
