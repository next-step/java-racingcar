package racing_car.step3.input;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static final String INPUT_NUMBER_OF_CARS_MESSAGE = "자동차 대수는 몇 대인가요?";
    public static final String INPUT_NUMBER_OF_TRY_MESSAGE = "시도할 회수는 몇 회 인가요?";
    
    public static int inputNumberOfCars() {
        System.out.println(INPUT_NUMBER_OF_CARS_MESSAGE);
        return inputNum();
    }
    
    public static int inputNumberOfTry() {
        System.out.println(INPUT_NUMBER_OF_TRY_MESSAGE);
        return inputNum();
    }
    
    private static int inputNum() {
        return SCANNER.nextInt();
    }
}
