package step3.view;

import step3.domain.value.Input;

import java.util.Scanner;

public class InputView {
    private String participantsInString;
    private Integer numOfRounds;

    public void render() {
        System.out.println("초간단 자동차 게임을 시작합니다!");

        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");

        participantsInString = scanner.nextLine();

        System.out.println("시도할 회수는 몇 회인가요?");
        numOfRounds = scanner.nextInt();
    }

    public Input readInput() {
        assert numOfRounds != null;
        assert participantsInString != null;
        return new Input(participantsInString, numOfRounds);
    }
}
