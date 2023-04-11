package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingGame {
    int carCount, tryCount;
    Cars cars;

    public void insertNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        this.carCount = scanner.nextInt();
        System.out.println("시도할 회수는 몇 대 인가요?");
        this.tryCount = scanner.nextInt();
    }

    public void initializeCars() {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
        cars = new Cars(carList);
    }

    public void race() {
        System.out.println("실행결과");
        for (int i = 0; i < tryCount; i++) {
            cars.moveCars();
            cars.printCarsScore();
        }
    }


}
