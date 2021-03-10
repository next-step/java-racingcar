package racing.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private final Scanner scan = new Scanner(System.in);
    private final String participationList;
    private int turnCount;

    public InputView() {
        this.participationList = inputRacingCarName();
        this.turnCount = inputTurnCount();
    }

    public String inputRacingCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scan.nextLine();
    }

    public int inputTurnCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            turnCount = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("숫자만 입력 가능합니다.");
        }
        return turnCount;
    }

    public String getParticipationList() {
        return participationList;
    }

    public int getTurnCount() {
        return turnCount;
    }
}
