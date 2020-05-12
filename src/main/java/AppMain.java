import calculator.Calculator;

import java.util.Scanner;

public class AppMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        print("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();

        print("시도할 회수는 몇 회 인가요?");
        int time = scanner.nextInt();

    }

    public static void print(String text) {
        System.out.println(text);
    }
}
