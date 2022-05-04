package view;

import java.util.Scanner;

public class InputView {

    Scanner scanner = new Scanner(System.in);

    public String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요 : ");
        return scanner.nextLine();
    }

    public int getNumberOfRounds() {
        System.out.println("시도할 회수는 몇 회인가요? : ");
        return scanner.nextInt();
    }
}
