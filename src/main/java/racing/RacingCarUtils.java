package racing;

import java.util.ArrayList;
import java.util.List;

public class RacingCarUtils {

    public static List<Car> getCarList(int carCnt, int moveCnt) {

        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < carCnt; i++) {
            Car car = new Car();
            car.move(moveCnt);
            carList.add(car);
        }
        return carList;
    }

    public static void viewRacingCar(List<Car> carList, int moveCnt, int carCnt) {

        for (int i = 0; i < moveCnt; i++) {

            System.out.println("round" + (i + 1));

            for (int j = 0; j < carCnt; j++) {

                System.out.print("car" + (j + 1) + ": ");

                for (int k = 0; k < i + 1; k++) {
                    if (carList.get(j).getMoveList().get(k) == 1) {
                        System.out.print("-");
                    }
                }

                System.out.println();
            }

            System.out.println();

        }
    }
}
