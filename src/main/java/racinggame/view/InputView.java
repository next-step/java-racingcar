package racinggame.view;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_REQUEST_CAR_NAMES_ANNOUNCE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_REQUEST_ROUND_ANNOUNCE = "시도할 회수는 몇 회 인가요?";

    private String carNames;
    private int gameCount;

    public InputView() {
    }

    public void readUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(INPUT_REQUEST_CAR_NAMES_ANNOUNCE);
        this.carNames = scanner.nextLine();
        System.out.println(INPUT_REQUEST_ROUND_ANNOUNCE);
        this.gameCount = scanner.nextInt();
    }

    public String getCarNames() {
        return carNames;
    }

    public int getGameCount() {
        return gameCount;
    }
}
