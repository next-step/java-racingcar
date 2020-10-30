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

        Memento memento = new Memento(carNum, tryNum);
        RacingGame game = new RacingGame(memento);
        View view = new View(memento);
        RandomGenerator random = RandomGenerator.getInstance();

        while (game.checkNotGameOver()) {
            System.out.println(view);
            game.play(random);
        }
    }
}
