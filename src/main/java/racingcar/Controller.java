package racingcar;

import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {

        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = InputView.nextInt();
        Cars cars = new Cars(carCount);

        System.out.println("시도할 회수는 몇 회 인가요?");
        int playCount = InputView.nextInt();

        System.out.println("실행 결과");

        int startCount = 0;
        while ( startCount != playCount) {
            cars.play();
            ResultView.printCars(cars);
            System.out.println("\n");
            startCount++;
        }

    }



}
