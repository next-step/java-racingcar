package CarRacing.view;

import java.util.Scanner;

import exception.NegativeInputException;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public int getNumberOfCar() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        String numberStr = SCANNER.nextLine();

        try {
            return getNumber(numberStr);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getNumberOfCar();
        }
    }

    public int getNumberOfTry() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        String numberStr = SCANNER.nextLine();

        try {
            return getNumber(numberStr);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getNumberOfCar();
        }
    }

    public boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public int getNumber(String numberStr) {
        if (!isNumeric(numberStr)) {
            throw new IllegalArgumentException("숫자로만 입력해주세요!");
        }

        int numberOfCar = Integer.parseInt(numberStr);
        if (numberOfCar < 0 ) {
            throw new NegativeInputException("양의 숫자만 입력해주세요!");
        }

        return numberOfCar;
    }

    private static boolean emptyText(String inputText) {
        return (inputText == null) || inputText.isEmpty() || inputText.isBlank();
    }
}
