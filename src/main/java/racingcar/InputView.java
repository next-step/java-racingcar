package racingcar;

import java.util.Scanner;

public class InputView {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차는 몇 대인가요?");
        int numberOfCars = scanner.nextInt();
        System.out.println("몇 번 시도하나요?");
        int numberOfAttempts = scanner.nextInt();
    }
}
