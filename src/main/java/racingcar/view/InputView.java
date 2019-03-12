package racingcar.view;

import java.util.Scanner;

public class InputView {

    Scanner scanner = new Scanner(System.in);

    public int setCarCount() {
        System.out.println("몇대로 플레이 할거에요?");
        return scanner.nextInt();
    }

    public int setRound() {
        System.out.println("몇 라운드 실행 할거에요?");
        return scanner.nextInt();
    }

}
