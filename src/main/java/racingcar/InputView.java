package racingcar;

import java.util.Scanner;

public class InputView {
    private int time;
    private int[] carPositions = {0, 0, 0};

    /**
     * 자동차 대수와 시도 회수를 입력받는다.
     */
    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        carPositions = new int[scanner.nextInt()];
        System.out.println("시도할 회수는 몇 회 인가요?");
        time = scanner.nextInt();
    }

    public int getTime() {
        return time;
    }

    public int[] getCarPositions() {
        return carPositions;
    }
}
