package step3;

import step3.car.game.CarGame;

import java.util.Scanner;

public class AppMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String cars = scanner.nextLine();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int numberOfMoves = scanner.nextInt();

        CarGame carGame = new CarGame(cars.split(","), numberOfMoves);
        System.out.println("실행 결과");
        carGame.start();
    }
}
