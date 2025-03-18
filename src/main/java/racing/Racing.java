package racing;

import static java.lang.System.*;

import java.util.HashMap;
import java.util.Scanner;

public class Racing {
    protected int moveCount;
    protected int carCount;
    protected CarGroup cars;

    /**
     * 초기 경주 필드 생성
     */
    public Racing() {
    }

    /**
     * 자동차 대수와 시도할 횟수 입력받는 메서드
     */
    public Racing init() {
        Scanner scanner = new Scanner(System.in);
        out.println("자동차 대수는 몇 대 인가요?");
        this.carCount = scanner.nextInt();
        out.println("시도할 회수는 몇 회 인가요?");
        this.moveCount = scanner.nextInt();
        scanner.close();

        HashMap<Integer, Car> cars = new HashMap<>();
        for (int i = 0; i < carCount; i++) {
            cars.put(i, new Car());
        }
        this.cars = new CarGroup(cars);
        return this;
    }

    /**
     * 실제 자동차 이동 메서드
     */
    public void run() {
        for (int i = 0; i < this.moveCount; i++) {
            cars.go();
            cars.printPosition();
        }
    }
}
