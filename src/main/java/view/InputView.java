package view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public InputViewDto init() {
        String name = askName();
        int round = askRound();
        return new InputViewDto(name, round);
    }

    /**
     * 자동차 이름을 입력받는 메서드
     */
    public String askName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    /**
     * 자동차 라운드를 입력받는 메서드
     */
    public int askRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }
}
