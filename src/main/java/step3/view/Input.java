package step3.view;

import java.util.Scanner;

public class Input {

    public static Integer getCuntOfCar() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static Integer getCuntOfTry() {
        System.out.println("시도할 횟수는?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
