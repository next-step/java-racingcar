package step3;

import java.util.Scanner;

public class InputView {


    public static Racing createRacing() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carNumber = scanner.nextInt();
        System.out.println("시도할 횟수는 몇 회 인가여?");
        int tryNumber = scanner.nextInt();
        return new Racing(carNumber, tryNumber);
    }
}
