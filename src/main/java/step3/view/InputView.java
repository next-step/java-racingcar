package step3.view;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_NUMBER_OF_CAR_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String INPUT_NUMBER_OF_ROUND_MESSAGE = "시도할 회수는 몇 회 인가요?";

    public static Integer getNumberOfCars() {
        return getConsoleInput(INPUT_NUMBER_OF_CAR_MESSAGE);
    }

    public static Integer getNumberOfRounds() {
        return getConsoleInput(INPUT_NUMBER_OF_ROUND_MESSAGE);
    }

    private static Integer getConsoleInput(String inputNumberOfRoundMessage) {
        print(inputNumberOfRoundMessage);
        return scanInput(new Scanner(System.in));
    }

    private static Integer scanInput(Scanner scanner) {
        return scanner.nextInt();
    }

    private static void print(String input){
        System.out.println(input);
    }

}
