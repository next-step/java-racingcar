package racingcargame;

import java.util.Scanner;

public class InputView {

    public static int carNumber;
    public static int playCount;

    public void input() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        carNumber = scanner.nextInt();
        System.out.println("입력한 자동차 대수는 " + carNumber + "대 입니다.");

        System.out.println("시도할 횟수는 몇 회 인가요?");
        playCount = scanner.nextInt();
        System.out.println("시도할 횟수는 " + playCount + "회 입니다.");
    }
}
