package racingcar.view;

import racingcar.domain.Race;

import java.util.Scanner;

public class InputView {
    static final String INPUT_CAR_NUM_INSTRUCTION
            = "레이스에 참가하는 자동차의 이름을 입력하세요(이름은 쉽표(,)를 기준으로 구분) : ";
    static final String INPUT_ROUND_NUM_INSTRUCTION
            = "진행할 레이스의 라운드 수를 입력하세요 : ";

    public static String[] inputNamesOfCars() {
        String input = "";

        do {
            System.out.print(INPUT_CAR_NUM_INSTRUCTION);
            input = new Scanner(System.in).nextLine();
        } while (!isValidInputOfCars(input));

        return getNamesOfCars(input);
    }

    public static boolean isValidInputOfCars(String input) {
        if (input == null || input.trim().isEmpty()) {
            System.out.println("Nothing has been entered");
            return false;
        }

        boolean result = true;
        String[] carNames = getNamesOfCars(input);
        for (String name : carNames) {
            result &= !name.isEmpty();
        }

        if (result == false) {
            System.out.println("empty string is invalid for car name");
        }

        return result;
    }

    static String[] getNamesOfCars(String input) {
        String[] names = input.split(",");

        for (int i = 0; i < names.length; i++) {
            names[i] = names[i].trim();
        }

        return names;
    }

    static boolean isValidInputOfRoundNum(int input) {
        if (input < Race.MIN_ROUND_NUM) {
            System.out.println("invalid input for the number of round : " + input);
            return false;
        }

        return true;
    }

    public static int inputRoundNum() {
        int input;

        do {
            System.out.print(INPUT_ROUND_NUM_INSTRUCTION);
            input = new Scanner(System.in).nextInt();
        } while (!isValidInputOfRoundNum(input));

        return input;
    }
}
