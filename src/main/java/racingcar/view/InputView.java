package racingcar.view;

import java.util.Scanner;

public class InputView {
    public String inputString() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
    public int inputInt() {
        System.out.println("시도할 회수는 몇회인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }


}
