package car_racing2.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String DELIMITER = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public static InputData getRaceInput() {
        List<String> carNames = getNames();
        Integer numOfRounds = getNumberOfRound();
        return new InputData(carNames, numOfRounds);
    }

    private static List<String> getNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] names = scanner.nextLine().split(DELIMITER);
        return getNames(names);
    }

    private static int getNumberOfRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        int numOfRound = scanner.nextInt();
        validateNumberOfRounds(numOfRound);
        return numOfRound;
    }

    private static List<String> getNames(String[] names) {
        List<String> nameList = Arrays.asList(names);
        validateNames(nameList);
        return nameList;
    }

    private static void validateNames(List<String> names) {
        if (names.isEmpty()) throw new IllegalArgumentException("하나 이상의 이름을 입력해야 합니다.");
    }

    private static void validateNumberOfRounds(int numOfRounds) {
        if (numOfRounds < 1) throw new IllegalArgumentException("게임 횟수는 1회 이상이어야 합니다.");
    }
}
