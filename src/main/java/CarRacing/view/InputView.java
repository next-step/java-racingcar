package CarRacing.view;

import java.util.Scanner;

import exception.NegativeInputException;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public int getNumberOfCar(String numberStr) {
        if (emptyText(numberStr)) {
            System.out.println("자동차 대수는 몇 대 인가요?");
            numberStr = SCANNER.nextLine();
        }

        if (!isNumeric(numberStr)) {
            throw new IllegalArgumentException("차량 대수는 숫자로만 입력해주세요!");
        }

        int numberOfCar = Integer.parseInt(numberStr);
        if (numberOfCar < 0 ) {
            throw new NegativeInputException("차량 대수는 양의 숫자만 입력해주세요!");
        }

        return numberOfCar;
    }

    public int getNumberOfTry(String numberStr) {
        if (emptyText(numberStr)) {
            System.out.println("시도할 횟수는 몇 회 인가요?");
            numberStr = SCANNER.nextLine();
        }

        if (!isNumeric(numberStr)) {
            throw new IllegalArgumentException("시도 횟수는 숫자로만 입력해주세요!");
        }

        int numberOfTry = Integer.parseInt(numberStr);
        if (numberOfTry < 0 ) {
            throw new NegativeInputException("시도 횟수는 양의 숫자만 입력해주세요!");
        }

        return numberOfTry;
    }

    public boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    private static boolean emptyText(String inputText) {
        return (inputText == null) || inputText.isEmpty() || inputText.isBlank();
    }
}
