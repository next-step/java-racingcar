package racing.ui;

import java.util.Scanner;

public class InputView {

    private static final String RACING_CAR_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String RACING_GAME_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private int racingCar;

    private int racingRound;


    public InputView() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(RACING_CAR_MESSAGE);
        this.racingCar = scanner.nextInt();

        System.out.println(RACING_GAME_MESSAGE);
        this.racingRound = scanner.nextInt();
    }

    public int getRacingCar() {
        return racingCar;
    }

    public int getRacingRound() {
        return racingRound;
    }

}
