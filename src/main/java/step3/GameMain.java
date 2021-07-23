package step3;

import java.util.Scanner;

public class GameMain {
    public static void main(String[] args) {
        Scanner standardInput = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");

        int nCars = standardInput.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");

        int nTurns = standardInput.nextInt();
    }
}
