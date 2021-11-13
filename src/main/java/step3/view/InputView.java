package step3.view;

import step3.domain.value.Input;

import java.util.Scanner;

public class InputView {
    private Integer numOfParticipants;
    private Integer numOfRounds;

    public void render() {
        System.out.println("초간단 자동차 게임을 시작합니다!");

        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대인가요?");

         numOfParticipants = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회인가요?");
        numOfRounds = scanner.nextInt();
    }

    public Input readInput() {
        assert numOfRounds != null;
        assert numOfParticipants != null;
        return new Input(numOfParticipants, numOfRounds);
    }
}
