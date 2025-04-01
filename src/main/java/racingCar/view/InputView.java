package racingCar.view;

import racingCar.domain.CarNames;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER = ",";

    public static CarNames getCarNamesFromUser() {
        System.out.println("자동차 이름을 입력하세요(이름은 쉼표(,)로 구분): ");
        String input = SCANNER.nextLine();
        List<String> names = turnStringToList(input);
        return new CarNames(names);
    }

    private static List<String> turnStringToList(String input) {
        List<String> carNamesList = Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
        return carNamesList;
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
