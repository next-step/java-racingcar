package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingCar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCnt = Integer.parseInt(scanner.nextLine());
        System.out.println("시도할 회수는 몇 회 인가요?");
        int moveCnt = Integer.parseInt(scanner.nextLine());

        List<List<Integer>> carList = new ArrayList<>();

        for (int i = 0; i < carCnt; i++) {
            Car car = new Car();
            carList.add(car.moveCar(moveCnt));
        }

        viewRacingCar(carList, moveCnt, carCnt);

    }

    public static void viewRacingCar(List<List<Integer>> carList, int moveCnt, int carCnt) {

        for (int i = 0; i < moveCnt; i++) {

            System.out.println("round" + (i + 1));

            for (int j = 0; j < carCnt; j++) {

                System.out.print("car" + (j + 1) + ": ");

                for (int k = 0; k < i + 1; k++) {
                    if (carList.get(j).get(k) == 1) {
                        System.out.print("-");
                    }
                }

                System.out.println();
            }

            System.out.println();

        }
    }

}
