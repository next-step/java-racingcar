package mission1.step3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carNumber = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int execNumber = scanner.nextInt();

        System.out.println("실행결과");
        CarRace.getInstance(carNumber, execNumber)
                .start();
    }
}
