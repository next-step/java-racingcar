package racing.view;

import java.util.Scanner;

public class GameInput {

    private static final String ASK_CAR_COUNT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ASK_ROUND_COUNT = "시도할 회수는 몇 회 인가요?";

    private final Scanner scanner = new Scanner(System.in);

    public String[] getCarArrayBySplit() {
        System.out.println(ASK_CAR_COUNT);
        return scanner.nextLine().split(",");
    }

    public int roundCount() {
        System.out.println(ASK_ROUND_COUNT);
        return scanner.nextInt();
    }
}
