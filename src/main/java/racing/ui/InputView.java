package racing.ui;

import java.util.List;
import java.util.Scanner;

public class InputView {

    static Scanner SCANNER = new Scanner(System.in);

    static String TRY_COUNT = "시도할 회수는 몇 회 인가요?";

    static String CAR_COUNT = "자동차 대수는 몇 대 인가요?";
    static String CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    private static int carCount = 0;

    private static int tryCount = 0;

    private static String carNames = "";

    public static int getTryCount() {
        System.out.println(TRY_COUNT);
        return SCANNER.nextInt();
    }

    public static int getCarCount() {
        System.out.println(CAR_COUNT);
        return SCANNER.nextInt();
    }

    public static String getCarName(){
        System.out.println(CAR_NAMES);
        return SCANNER.nextLine();
    }

}
