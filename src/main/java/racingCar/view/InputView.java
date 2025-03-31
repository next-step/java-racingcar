package racingCar.view;

import racingCar.domain.CarNames;

import java.util.*;
import java.util.regex.Pattern;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER = ",";
    private static final Pattern VALID_CAR_NAME_PATTERN = Pattern.compile("^[\\w가-힣]+(,[\\w가-힣]+)*$");

    public static CarNames getCarNamesFromUser() {
        System.out.println("자동차 이름을 입력하세요(이름은 쉼표(,)로 구분): ");
        String input = SCANNER.nextLine();
        return new CarNames(input);
    }

    public static int getRoundsCountFromUser() {
        System.out.println("시도할 회수는 몇회인가요?");
        String rounds = SCANNER.nextLine();
        while (isInvalidRounds(rounds)) {
            System.out.println("양의 정수만 허용됩니다.");
            rounds = SCANNER.nextLine();
        }
        return Integer.parseInt(rounds);
    }

    public static boolean isInvalidRounds(String rounds) {
        try {
            Integer.parseInt(rounds);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }
}
