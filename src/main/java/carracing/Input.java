package carracing;

import java.util.Scanner;

public class Input {

    String carName;
    int raceCount;

    public void insertCarName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        carName = scanner.nextLine();
    }

    public void insertGameCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("시도할 횟수는 몇 회인가요?");
        raceCount = scanner.nextInt();
    }

    public String getCarName() {
        return carName;
    }

    public int getRaceCount() {
        return raceCount;
    }
}
