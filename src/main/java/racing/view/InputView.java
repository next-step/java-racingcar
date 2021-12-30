package racing.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);
    private static final int MAX_NAME_LENGTH = 5;

    public InputView() {
    }

    public static List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String cars = sc.nextLine();
        String[] names = cars.split(",");

        return Arrays.stream(names)
            .filter(InputView::isValidName)
            .collect(Collectors.toList());

    }

    public static int inputTotalRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        return sc.nextInt();
    }

    private static boolean isValidName(String name) {
        return (name.length() > 0) && (name.length() <= MAX_NAME_LENGTH);
    }

}
