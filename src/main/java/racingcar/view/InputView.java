package racingcar.view;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_NAMES_MENT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TIMES_MENT = "시도할 회수는 몇 회 인가요?";
    private int times;
    private List<String> names;

    public void input() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(INPUT_NAMES_MENT);
            names = Arrays.asList(scanner.nextLine().split(","));
            System.out.println(INPUT_TIMES_MENT);
            times = scanner.nextInt();

            checkRaceCondition();
        } catch (InputMismatchException e) {
            System.out.println("자연수만 입력할 수 있습니다.");
        }
    }

    private void checkRaceCondition() {
        if (names.size() == 0) {
            throw new RuntimeException("경주에는 최소 1대 이상의 자동차가 필요합니다.");
        }
        if (times <= 0) {
            throw new RuntimeException("시도할 회수는 자연수만 입력할 수 있습니다.");
        }
    }

    public List<String> getNames() {
        return names;
    }

    public int getTimes() {
        return times;
    }
}