package racingcar;

import java.util.Scanner;

public class Input {
    private final Scanner scanner = new Scanner(System.in);

    public String carName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.next();
    }

    public int gameCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        String name = new Input().carName();
        System.out.println(name);
    }
}