package racing.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return Arrays.stream(sc.nextLine().split(",")).collect(Collectors.toList());
    }

    public static int getTotalRoundNumber() {
        System.out.println("시도할 횟수는 몇회인가요?");
        return Integer.parseInt(sc.nextLine());
    }
}
