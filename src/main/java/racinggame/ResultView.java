package racinggame;

import java.util.List;

/**
 * 1. "-" 상수
 * 1. 게임 수 만큼 자동차 이동
 * 1. Car의 이동 거리 만큼 - 표기
 */
public class ResultView {
    private static final char DASH = '-';

    protected static void racingGameStart(int gameCount, List<Car> cars) {
        for (int i = 0; i < gameCount; i++) {
            playOneRound(cars);
        }
    }

    protected static void playOneRound(List<Car> cars) {
        for (Car car : cars) {
            car.moveCar();
            System.out.println(drawDash(car.getMoveRange()));
        }

        System.out.println("");
    }

    protected static String drawDash(int repeat) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < repeat; i++) {
            sb.append(DASH);
        }
        return sb.toString();
    }
}
