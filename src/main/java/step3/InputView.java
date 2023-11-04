package step3;

import java.util.Scanner;

public class InputView {

    private int carNumber;
    private int tryCount;

    public void readInput() {
        Scanner scanner = new Scanner(System.in);

        // 사용자에게 메시지를 출력하고 입력을 받습니다.
        System.out.println("자동차 대수는 몇 대 인가요? ");
        carNumber = scanner.nextInt(); // 정수를 읽습니다.

        System.out.println("시도할 회수는 몇 회 인가요? ");
        tryCount = scanner.nextInt(); // 정수를 읽습니다.

        // 입력을 출력합니다.
        System.out.println("자동차 대수: " + carNumber);
        System.out.println("시도할 회수: " + tryCount);

        // 스캐너를 닫습니다.
        scanner.close();
    }


    public int getCarNumber() {
        return carNumber;
    }

    public int getTryCount() {
        return tryCount;
    }

}
