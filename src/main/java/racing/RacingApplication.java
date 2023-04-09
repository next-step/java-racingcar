package racing;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingApplication {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int totalCarNumber = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int opportunity = scanner.nextInt();

        List<Car> carList = Car.createCarList(totalCarNumber);

        System.out.println("실행 결과");
        for (int i = 0; i < opportunity; i++) {
            for (Car racingCar : carList) {
                int randomNumber = random.nextInt(10);
                racingCar.move(randomNumber);
                PrintUtil.drawPosition(racingCar.valueOfPosition());
            }
            System.out.println("");
        }

    }
}
