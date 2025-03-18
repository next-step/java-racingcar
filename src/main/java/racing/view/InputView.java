package racing.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    public static final String DELIMITER = ",";

    public static String[] getCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        return scanner.nextLine().split(DELIMITER);
    }

    public static int getMoveCount() {
        System.out.println("시도할 횟수는 몇 대 인가요?");
        return scanner.nextInt();
    }

}
