package racing_car.step4.input;

import java.util.Scanner;

public class InputView {
    private static final String NEGATIVE_NUMBER_EXCEPTION_MESSAGE = "음수는 입력할 수 없습니다. 다시 입력해주세요.";
    private static final String INPUT_NUMBER_OF_CARS_MESSAGE = "자동차 대수는 몇 대인가요?";
    private static final String INPUT_NUMBER_OF_TRY_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final String NUMBER_FORMAT_EXCEPTION_MESSAGE = "숫자만 입력할 수 있습니다. 다시 입력해 주세요.";
    private static final int POSITION_MIN_NUMBER = 0;
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
            checkNegative(inputNum);
            return inputNum;
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
            return correctNum();
        } catch (NumberFormatException e) {
            System.out.println(NUMBER_FORMAT_EXCEPTION_MESSAGE);
            return correctNum();
        }
    }
    
    private static void checkNegative(int inputNum) throws UnsupportedOperationException {
        if (inputNum < POSITION_MIN_NUMBER) {
            throw new UnsupportedOperationException(NEGATIVE_NUMBER_EXCEPTION_MESSAGE);
        }
    }
    
    private static int inputNum() throws UnsupportedOperationException {
        return Integer.parseInt(SCANNER.nextLine());
    }
}
