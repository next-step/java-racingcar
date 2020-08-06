package step3;

import java.util.Scanner;

public class CarRace {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int count = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int rounds = scanner.nextInt();

        Circuit circuit = new Circuit(count, rounds);

        while (circuit.lap()) {
            circuit.printStatus();
            System.out.println();
        }
    }

}
