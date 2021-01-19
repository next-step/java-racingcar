import racingcar.Car;
import racingcar.RacingCar;

import java.util.Scanner;

public class RacingGame {
    public static void main(String[] args){
        System.out.println("경주할 자동차 이름을 입력하세요:");
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split(",");
        for (String name : names) {
            Car car = new RacingCar(name);
            car.go();
            car.print();
        }
    }
}