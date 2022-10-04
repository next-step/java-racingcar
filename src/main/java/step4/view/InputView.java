package step4.view;

import java.util.Random;
import java.util.Scanner;

public class InputView {

    public static Scanner scanner = new Scanner(System.in);

    public String carName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분");
        return scanner.nextLine();
    }

    public int carNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return scanner.nextInt();
    }
}
