package racing.ui;

import java.util.Scanner;

public class InputView {

    private static final String PARTICIPATION_CAR_MESSAGE = "자동차는 몇 대 인가요?";
    private static final String NUMBER_OF_ATTEMPT_MESSAGE = "시도 횟수는 몇 회 인가요?";

    public static int inputParticipationCars() {
        System.out.println(PARTICIPATION_CAR_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static int inputNumberOfAttempt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(NUMBER_OF_ATTEMPT_MESSAGE);
        return scanner.nextInt();
    }

}
