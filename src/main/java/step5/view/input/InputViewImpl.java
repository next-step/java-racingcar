package step5.view.input;

import java.util.Scanner;

public class InputViewImpl implements InputView {
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public String inputParticipant() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    @Override
    public int inputTryCnt() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }
}
