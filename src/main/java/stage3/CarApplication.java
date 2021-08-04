package stage3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarApplication {
    private static int carNum;
    private static int tryNum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        carNum = sc.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        tryNum = sc.nextInt();

        List<Car> carList = new ArrayList<>(carNum);
        for (int i = 0; i < carNum; i++) {
            carList.add(new Car());
        }

        System.out.println("실행 결과");
        for (int i = 0; i < tryNum; i++) {
            for (Car car : carList) {
                if (car.isForward(car.getForwardCondition())) car.forward();
                System.out.println(car.getStatus());
            }
            System.out.println();
        }
    }
}
