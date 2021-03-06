package racing.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    Scanner scan = new Scanner(System.in);

    private String participationList;
    private int turnCount;

    public void init() {
        this.participationList = inputRacingCarName();
        this.turnCount = intputTurnCount();
    }

    public String inputRacingCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scan.nextLine();
    }

    public int intputTurnCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            turnCount = scan.nextInt();
        } catch (InputMismatchException e) {
            reStart();
        }
        return turnCount;
    }

    public void reStart() {
        System.out.println("입력하신 값은 올바른 값이 아닙니다. 다시 입력해주세요");
        init();
    }

    public String getParticipationList() {
        return participationList;
    }

    public int getTurnCount() {
        return turnCount;
    }
}
