package racingcar;

import java.util.Scanner;

public class Application {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("움직일 자동차의 대수는?");
        int numberOfCar = scanner.nextInt();
        System.out.println(numberOfCar + "대입니다!");

    }
}
