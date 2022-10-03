package racingcar;

import java.util.Scanner;

public class InputView {
    private static final Scanner  scanner = new Scanner(System.in);

    public static int getNumOfCars() {
        System.out.print("자동차 대수는 몇 대 인가요?");
        int numOfCars = scanner.nextInt();

        if(numOfCars < 0 || numOfCars > 100) {
            throw new RuntimeException("1에서 99까지의 숫자만 입력해주세요.");
        }

        return numOfCars;
    }

    public static int getTryCount() {
        System.out.print("시도할 회수는 몇 회 인가요?");
        int count = scanner.nextInt();

        if(count < 0 || count > 100) {
            throw new RuntimeException("1에서 99까지의 숫자만 입력해주세요.");
        }

        return count;
    }


}
