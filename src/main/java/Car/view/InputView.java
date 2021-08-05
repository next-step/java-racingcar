package Car.view;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputView {
    private Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public int getInt(String message) {
        System.out.println(message);
        int returnNumber = 0;
        try {
            returnNumber = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("숫자 값을 입력해주세요.");
        }
        return returnNumber;
    }

    public String[] getCarNames(String message){
        System.out.println(message);
        String carNames = "";
        String[] returnNames = null;
        try {
            carNames = scanner.nextLine();
            validateStringVoid(carNames);
            returnNames = splitCarNames(carNames);
        } catch (IllegalStateException e) {
            throw new IllegalStateException("scanner가 닫혀있습니다.");
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("입력값을 받지 못 했습니다..");
        }
        return returnNames;
    }

    private void validateStringVoid(String s) {
        if (s == null || s.trim().isEmpty()) {
            throw new IllegalArgumentException("빈값을 입력받았습니다.");
        }
    }

    private String[] splitCarNames(String carNames){
        String[] splitCarName = carNames.split(",");
        for (int i = 0; i < splitCarName.length; i++) {
            String carName = splitCarName[i].trim();
            validateStringVoid(carName);
            splitCarName[i] = carName;
        }
        return splitCarName;
    }


}
