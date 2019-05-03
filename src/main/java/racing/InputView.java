package racing;

import java.util.Scanner;

import static racing.Utils.splitCarNames;

public class InputView {
    static Scanner scanner = new Scanner(System.in);

    static String[] getNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner scanner = new Scanner(System.in);
        return splitCarNames(scanner.next());
    }

    public static int inputCarNum() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carNum = scanner.nextInt();
        return carNum;
    }

    public static int inputTryTime() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryTime = scanner.nextInt();
        return tryTime;
    }
}
