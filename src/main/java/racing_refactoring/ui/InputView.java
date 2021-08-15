package racing_refactoring.ui;

import java.util.Scanner;

public class InputView {

    private static final String RACING_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String RACING_GAME_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private final Scanner RACING_SCANNER = new Scanner(System.in);

    private String racingCar;
    private int racingRound;

    public InputView() {

        System.out.println(RACING_CAR_MESSAGE);
        this.racingCar = RACING_SCANNER.nextLine();

        System.out.println(RACING_GAME_MESSAGE);
        this.racingRound = RACING_SCANNER.nextInt();
    }

    public String getRacingCar() {
        return racingCar;
    }

    public int getRacingRound() {
        return racingRound;
    }

}
