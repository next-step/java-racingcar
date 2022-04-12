package camp.nextstep;

import camp.nextstep.racingcar.CarRacing;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for user input
        System.out.println("자동차 대수는 몇 대인가요?");
        int countOfCar = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int numberOfRacing = scanner.nextInt();

        System.out.println(countOfCar);
        System.out.println(numberOfRacing);
    }
}
