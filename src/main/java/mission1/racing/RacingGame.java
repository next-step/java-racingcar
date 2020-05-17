package mission1.racing;

import java.util.Scanner;

public class RacingGame {
    private int time;
    private int carNumber;

    Movement movement = new Movement();

    public void startGame() {
        setGame();

        for(int i = 0; i < time; i++) {
            movement.move();
        }
    }

    private void setGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        carNumber = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        time = scanner.nextInt();
    }
}
