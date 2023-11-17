package racing.view;

import racing.model.Names;

import java.util.Scanner;

public class InputView {
    Scanner scanner;
    public InputView() {
        scanner = new Scanner(System.in);
    }

    public Names getCarName() throws IllegalAccessException {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return new Names(scanner.nextLine().split(","));
    }

    public int getRaceRound(){
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

}
