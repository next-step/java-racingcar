package racingcarbasic;

import java.util.Scanner;

public class InputView {

    public int getCarNum() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int carNum = scanner.nextInt();

        return carNum;
    }

    public int getMoveCount() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("시도할 회수는 몇 회 인가요?");
        int moveCount = scanner.nextInt();

        return moveCount;
    }


}
