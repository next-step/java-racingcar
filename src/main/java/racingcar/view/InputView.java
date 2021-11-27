package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER = ",";
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public List<String> inputCarNames() {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
            String input = SCANNER.nextLine();
            List<String> names = Arrays.asList(input.split(DELIMITER));
            checkNames(names);

            return names;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCarNames();
        }
    }

    public int inputLastRound() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return SCANNER.nextInt();
    }

    boolean isValidName(String name) {
        return name != null && name.length() <= MAX_CAR_NAME_LENGTH;
    }

    void checkNames(List<String> names) {
        boolean isValid = names.stream()
                .allMatch(this::isValidName);
        if (!isValid) {
            throw new IllegalArgumentException("자동차 이름은 5자를 넘길 수 없습니다.");
        }
    }
}
