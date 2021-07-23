package racing;

import java.util.Scanner;
public class RacingApplication {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("자동차 대수는 몇 대 인가요?");
            String carNum = sc.nextLine();
            System.out.println("시도할 회수는 몇 회 인가요?");


            String count = sc.nextLine();
            RacingCar racingCar = new RacingCar();
            racingCar.racing(Integer.parseInt(carNum), Integer.parseInt(count));
    }
}
