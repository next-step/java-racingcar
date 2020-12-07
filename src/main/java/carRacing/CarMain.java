package carRacing;

import java.util.Scanner;

public class CarMain {
    public static void main(String[] args) {
        Car car = new Car();
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        String value = scanner.nextLine();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int number = scanner.nextInt();
        car.inputGameInfo(value, number);
    }
}
