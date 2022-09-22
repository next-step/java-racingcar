package racing_car.step4.input;

import racing_car.step4.domain.Cars;
import racing_car.step4.domain.CarsFactory;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_CARS_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_NUMBER_OF_TRY_MESSAGE = "시도할 회수는 몇 회 인가요?";
    public static final String CAR_NAME_LENGTH_EXCEEDED_EXCEPTION_MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다. 다시 입력해 주세요.";
    private static final String NEGATIVE_NUMBER_EXCEPTION_MESSAGE = "음수는 입력할 수 없습니다. 다시 입력해주세요.";
    private static final String NUMBER_FORMAT_EXCEPTION_MESSAGE = "숫자만 입력할 수 있습니다. 다시 입력해 주세요.";
    public static final int CAR_NAME_MAX_LENGTH = 5;
    private static final int POSITION_MIN_NUMBER = 0;
    private static final Scanner SCANNER = new Scanner(System.in);
    
    public static Cars createCars() {
        System.out.println(INPUT_CARS_NAME_MESSAGE);
        return new Cars(CarsFactory.from(splitCarsCorrectName()));
    }
    
    private static String[] splitCarsCorrectName() {
        try {
            String[] carsNameSplit = getCarsNameSplit(SCANNER.nextLine());
            checkCarsNameLength(carsNameSplit);
            return carsNameSplit;
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
            return splitCarsCorrectName();
        }
    }
    
    private static String[] getCarsNameSplit(String input) {
        input = input.replace(" ", "");
        return input.split(",");
    }
    
    private static void checkCarsNameLength(String[] carsName) throws UnsupportedOperationException {
        for (String carName : carsName) {
            checkCarNameLength(carName);
        }
    }
    
    private static void checkCarNameLength(String carName) throws UnsupportedOperationException {
        if (carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new UnsupportedOperationException(CAR_NAME_LENGTH_EXCEEDED_EXCEPTION_MESSAGE);
        }
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
