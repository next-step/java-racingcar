package racingcar;

import java.util.Scanner;

public class InputView {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("<InputView>");
    }

    public static int getNumberOfCars() {
        System.out.print("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public static int getNumberOfGames() {
        System.out.print("시도할 횟수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
