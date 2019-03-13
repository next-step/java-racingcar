package racingcar.view;

import java.util.Scanner;

public class InputView {

    Scanner scanner = new Scanner(System.in);

    public String[] inputCarNames() {
        System.out.println("경주할 차 이름을 정해주세요! ");
//        String[] carNames = scanner.nextLine().split(",");
        return scanner.nextLine().split(",");
    }

    public int inputRound() {
        System.out.println("몇 라운드 실행 할거에요?");
        return scanner.nextInt();
    }

}
