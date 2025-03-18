package racingCar.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int numOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int numOfCars = scanner.nextInt();
        if(numOfCars < 1) {
            throw new RuntimeException("0 이하의 숫자는 입력 불가능 합니다.");
        }
        return numOfCars;
    }
    public static int times() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int times = scanner.nextInt();
        if(times < 1) {
            throw new RuntimeException("0 이하의 숫자는 입력 불가능 합니다.");
        }
        return times;
    }

}
