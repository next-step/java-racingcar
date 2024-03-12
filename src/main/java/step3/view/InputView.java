package step3.view;

import step3.application.domain.Racing;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.letRace();
    }

    public void letRace() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int moveCount = scanner.nextInt();

        System.out.println("\n실행 결과");
        Racing racing = new Racing(carCount);
        racing.startRace(moveCount);
    }
}
