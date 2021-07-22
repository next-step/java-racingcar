package step3;

import java.util.ArrayList;
import java.util.Scanner;

public class RacingCarGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCount = scanner.nextInt();

        Referee referee = new Referee(tryCount);
        CarStadium carstadium = new CarStadium(referee, new ArrayList<>());

        for (int i = 0; i < carCount; i++) {
            carstadium.enterCar(new Car(new CarEngine()));
        }

        System.out.println("실행 결과");

        for (int i = 0; i < tryCount; i++) {
            carstadium.moveCars();
            System.out.println("**********************");
            carstadium.showCarsLocation();
        }
    }
}
