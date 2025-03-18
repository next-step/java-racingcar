package racing;

import java.util.Random;
import java.util.Scanner;

public class Racing {
    protected int moveCount;
    protected int carCount;
    protected static Random random = new Random();
    protected Car[] cars;

    public Racing() {
    }

    /**
     * 자동차 대수와 시도할 횟수 입력받는 메서드
     */
    public void init() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        this.carCount = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        this.moveCount = scanner.nextInt();
        scanner.close();
    }

    /**
     * 실제 자동차 이동 메서드
     */
    public void run() {
        this.cars = new Car[this.carCount];
        for (int i = 0; i < this.carCount; i++) {
            cars[i] = new Car();
            cars[i].move(this.moveCount);
        }
    }

    /**
     * 자동차 클래스
     */
    static class Car {
        int position;

        Car() {
            this.position = 0;
        }

        void move(int moveCount) {
            for (int i = 0; i < moveCount; i++) {
                this.position += randomChecker();
            }
        }

        int randomChecker() {
            int randomInt = random.nextInt(10);
            if (randomInt >= 4) {
                return 1;
            }
            return 0;
        }
    }

}
