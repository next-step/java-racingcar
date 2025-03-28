package step4.view;

import step4.domain.CarNames;

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

    public static boolean isInvalidCarNames(String[] carNames) {

        if (carNames.length < 2) {
            System.out.println("경주를 위해 2개 이상의 차를 입력해 주세요.");
            return true;
        }

        Set<String> uniqueNames = new HashSet<>(List.of(carNames));
        if (uniqueNames.size() != carNames.length) {
            System.out.println("자동차 이름은 중복될 수 없어요!");
            return true;
        }

        for (String carName : carNames) {
            if (carName == null || carName.isBlank() || carName.length() > 5 || !VALID_CAR_NAME_PATTERN.matcher(carName).matches()) {
                return true;
            }
        }

        return false;
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
