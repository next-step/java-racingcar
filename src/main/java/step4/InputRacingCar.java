package step4;

import java.util.Scanner;

public class InputRacingCar {
    public static void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] names = scanner.next().split(",");

        System.out.println("시도할 회수는 몇회인가요?");
        int times = scanner.nextInt();

        for (String name : names) {
            System.out.println("name :: " + name);
        }

        System.out.println("times :: " + times);
    }
}
