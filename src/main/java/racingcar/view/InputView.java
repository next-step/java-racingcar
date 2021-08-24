package racingcar.view;

import org.codehaus.plexus.util.StringUtils;
import racingcar.domain.Race;
import racingcar.domain.RoundNum;

import java.util.Scanner;

public class InputView {
    static final String INPUT_CAR_NUM_INSTRUCTION
            = "레이스에 참가하는 자동차의 이름을 입력하세요(이름은 쉽표(,)를 기준으로 구분) : ";
    static final String INPUT_ROUND_NUM_INSTRUCTION
            = "진행할 레이스의 라운드 수를 입력하세요 : ";
    static final String NOTI_EMPTY_INPUT = "Nothing has been entered";
    static final String NOTI_EMPTY_CAR_NAME = "empty string is invalid for car name";
    static final String NOTI_INVALID_ROUNDNUM = "invalid input for the number of round : ";

    public static String[] inputNamesOfCars() {
        String input = "";

        do {
            System.out.print(INPUT_CAR_NUM_INSTRUCTION);
            input = new Scanner(System.in).nextLine();
        } while (!isValidInputOfCars(input));

        return getNamesOfCars(input);
    }

    public static boolean isValidInputOfCars(String input) {
        if (input == null || StringUtils.isBlank(input)) {
            System.out.println(NOTI_EMPTY_INPUT);
            return false;
        }

        boolean result = true;
        String[] carNames = getNamesOfCars(input);
        for (String name : carNames) {
            result &= !name.isEmpty();
        }

        if (result == false) {
            System.out.println(NOTI_EMPTY_CAR_NAME);
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
        if (input <= RoundNum.MIN_ROUND_NUM) {
            System.out.println(NOTI_INVALID_ROUNDNUM + input);
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
