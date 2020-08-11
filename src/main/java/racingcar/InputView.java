package racingcar;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {

    private static final String NAMES_REQUEST = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ROUNDS_REQUEST = "시도할 회수는 몇 회 인가요?";
    private static final String DELIMITER = ",";
    private static final int FORBIDDEN_NAME_LENGTH = 0;
    private static final int BEGIN_INDEX = 0;
    private static final int END_INDEX = 5;

    private static Scanner scanner = new Scanner(System.in);

    private void setupScanner() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
    }

    private String substringName(String name) {
        if (name.length() == FORBIDDEN_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
        if (name.length() > END_INDEX) {
            name = name.substring(BEGIN_INDEX, END_INDEX);
        }
        return name;
    }

    public String[] getNames() {
        setupScanner();
        System.out.println(NAMES_REQUEST);
        String line = scanner.nextLine();
        String[] strings = line.split(DELIMITER);
        return Arrays.stream(strings)
                .map(this::substringName)
                .toArray(String[]::new);
    }

    public int getRounds() {
        setupScanner();
        System.out.println(ROUNDS_REQUEST);
        int rounds = scanner.nextInt();
        return rounds;
    }

    public void close() {
        if (scanner != null) {
            scanner.close();
            scanner = null;
        }
    }
}
