package racing_car.step3.input;

import java.util.Scanner;

public class InputView {
    public static final String INPUT_NUMBER_OF_CARS_MESSAGE = "자동차 대수는 몇 대인가요?";
    public static final String INPUT_NUMBER_OF_TRY_MESSAGE = "시도할 회수는 몇 회 인가요?";
    public static final String NUMBER_FORMAT_EXCEPTION_MESSAGE = "숫자만 입력할 수 있습니다. 다시 입력해 주세요.";
    public static final String NEGATIVE_NUMBER_EXCEPTION_MESSAGE = "음수는 입력할 수 없습니다. 다시 입력해주세요.";
    
    private static final Scanner SCANNER = new Scanner(System.in);
    
    public static int inputNumberOfCars() {
        System.out.println(INPUT_NUMBER_OF_CARS_MESSAGE);
        return correctNum();
    }
    
    public static int inputNumberOfTry() {
        System.out.println(INPUT_NUMBER_OF_TRY_MESSAGE);
        int numberOfTry = correctNum();
        System.out.println();
        return numberOfTry;
    }
    
    private static int correctNum() {
        try {
            int inputNum = inputNum();
            negativeCheck(inputNum);
            return inputNum;
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
            return correctNum();
        }
    }
    
    static void negativeCheck(int inputNum) throws UnsupportedOperationException {
        if (inputNum < 0) {
            throw new UnsupportedOperationException(NEGATIVE_NUMBER_EXCEPTION_MESSAGE);
        }
    }
    
    private static int inputNum() throws UnsupportedOperationException {
        try {
            return Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException e) {
            throw new UnsupportedOperationException(NUMBER_FORMAT_EXCEPTION_MESSAGE);
        }
    }
}
