package racing.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class InputView {

    private static final String DELIMITER = ",";


    public static List<String> getCarNames() {
        String carNamesInput = getCarNamesInput("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return split(carNamesInput);
    }

    public static int getNumberOfLaps() {
        return getUserInputNumber("시도할 회수는 몇 회 인가요?");
    }

    private static int getUserInputNumber(String text) {
        System.out.println(text);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static String getCarNamesInput(String text) {
        System.out.println(text);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static List<String> split(String carNames) {
        return Arrays.stream(carNames.split(DELIMITER))
                .map(String::trim)
                .collect(toList());
    }
}
