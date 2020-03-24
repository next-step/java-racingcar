package RacingCar;

import java.util.Scanner;

class InputView {

    private static Scanner scanner = new Scanner(System.in);

    static void showInput() {
        String CAR_INPUT_MESSAGE = "자동차 대수는 몇 대 인가요?";
        String STAGE_INPUT_MESSAGE = "시도할 회수는 몇 회 인가요?";



        System.out.println(CAR_INPUT_MESSAGE);
        RacingGame.getInstance().setCar(scanner.nextInt());

        System.out.println(STAGE_INPUT_MESSAGE);
        RacingGame.getInstance().setStage(scanner.nextInt());
    }
}

