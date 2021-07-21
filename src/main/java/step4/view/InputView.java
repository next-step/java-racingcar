package step4.view;

import step4.game.GameDto;

import java.util.Scanner;

public class InputView {
    private InputView() {
    }

    static public GameDto initGameEnv() {
        Scanner scanner = new Scanner(System.in);

        InputView.viewCarCount();
        String names = scanner.nextLine();
        InputView.viewCount();
        int count = scanner.nextInt();

        return GameDto.of(names, count);
    }

    static public void viewCarCount() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    static public void viewCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }
}
