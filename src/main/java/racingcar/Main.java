/**
 * 클래스 이름: Main
 * 버전 정보: 0.1
 * 날짜: 2020.10.30
 * 저작권 주의: 없음
 */

package racingcar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(Const.HOW_MANY_CARS_STR);
        int carNum = scanner.nextInt();

        System.out.println(Const.HOW_MANY_TRIES_STR);
        int tryNum = scanner.nextInt();

        System.out.println(Const.EXECUTION_RESULT_STR);

        MoveStrategy strategy = new RandomMoveStrategy();
        Car[] carArr = new Car[carNum];
        for (int i = 0; i < carNum; i++) {
            carArr[i] = new Car(strategy);
        }
        Memento memento = new Memento(carArr, tryNum);
        RacingGame game = new RacingGame(memento);
        View view = new View(memento);

        while (game.checkNotGameOver()) {
            System.out.println(view);
            game.play();
        }
    }
}
