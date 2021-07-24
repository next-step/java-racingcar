package Car;

import java.util.Random;
import java.util.Scanner;

public class RacingCar {
    private Car[] cars;
    private int carCount;
    private int gameCount;
    private String[] gameResults;

    private final int NUMBERBOUND = 10;
    private final int MINMOVENUMBER = 4;

    public void gameStart() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        carCount = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        gameCount = scanner.nextInt();


    }

}
