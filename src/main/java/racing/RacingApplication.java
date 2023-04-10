package racing;

import java.util.List;
import java.util.Scanner;

public class RacingApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = sc.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int opportunity = sc.nextInt();
        System.out.println();

        Cars cars = new Cars(RacingSupporter.generateCarList(carCount));

        for (int i = 0; i < opportunity; i++) {
            List<Integer> randomList = NumberGenerator.generateRandomList(carCount);
            RacingSupporter.raceCars(cars, randomList);

            RacingPrinter.drawPositions(cars.valueOfCarsPosition());
        }
    }
}
