package CarRacing.view;

import java.util.Scanner;

import exception.NegativeInputException;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public String[] getCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String numberStr = SCANNER.nextLine();

        try {
            return getNameOfCars(numberStr);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCars();
        }
    }

    public int getNumberOfTry() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        String numberStr = SCANNER.nextLine();

        try {
            return getNumber(numberStr);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getNumberOfTry();
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

    private String[] getNameOfCars(String numberStr) {
        return numberStr.split(",");
    }
}
