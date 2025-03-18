package UI;

import java.util.Scanner;

import model.Racing;

public class InputView {


    public static Racing input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCount = scanner.nextInt();

        return new Racing(carCount, tryCount);
    }
}
