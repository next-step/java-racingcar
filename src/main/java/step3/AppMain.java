package step3;

import step3.car.game.CarGame;

import java.util.Scanner;

public class AppMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int numberOfCars = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int numberOfMoves = scanner.nextInt();

        CarGame carGame = new CarGame(numberOfCars, numberOfMoves);
        System.out.println("실행 결과");
        carGame.start();
    }
}
