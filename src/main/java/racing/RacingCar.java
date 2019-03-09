package racing;

import java.util.List;
import java.util.Scanner;

public class RacingCar {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCnt = Integer.parseInt(scanner.nextLine());
        System.out.println("시도할 회수는 몇 회 인가요?");
        int moveCnt = Integer.parseInt(scanner.nextLine());

        List<Car> carList = RacingCarUtils.getCarList(carCnt, moveCnt);

        RacingCarUtils.viewRacingCar(carList, moveCnt, carCnt);
    }

}
