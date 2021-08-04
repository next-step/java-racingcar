package stage3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarApplication {
    private static int carNum;
    private static int tryNum;

    public static void main(String[] args) {
        start();
        List<CarService> carList = init();

        System.out.println("실행 결과");
        execute(carList);
    }

    private static void execute(List<CarService> carList) {
        for (int i = 0; i < tryNum; i++) {
            for (CarService car : carList) {
                final int condition = car.getCondition();
                car.tryForward(condition);
                System.out.println(car.getStatus());
            }
            System.out.println();
        }
    }

    private static void start() {
        Scanner sc = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        carNum = sc.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        tryNum = sc.nextInt();
    }

    private static List<CarService> init() {
        List<CarService> carList = new ArrayList<>();
        for (int i = 0; i < carNum; i++) {
            carList.add(new CarService(new Car()));
        }
        return carList;
    }
}
