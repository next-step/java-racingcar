package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> inputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] nameList = scanner.next().split(",");
        return Arrays.asList(nameList);
    }

    public static int inputNumberOfRounds() {

        System.out.println("시도할 회수는 몇 회 인가요?");
        int numberOfRounds = scanner.nextInt();
        return numberOfRounds;
    }

}
