package racingcar.step5.view;

import java.util.Scanner;

public class InputView {

    private final Scanner sc = new Scanner(System.in);

    public String getCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요");
        return sc.nextLine();
    }

    public int countOfTry() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return sc.nextInt();
    }

}
