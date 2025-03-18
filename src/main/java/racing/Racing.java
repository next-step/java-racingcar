package racing;

import java.util.Scanner;

public class Racing {
    protected int moveCount;
    protected int carCount;

    public Racing() {}

    public void init() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        this.carCount = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        this.moveCount = scanner.nextInt();
        scanner.close();
    }

}
