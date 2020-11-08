package racingcar.step3.view;

import racingcar.step3.domain.Car;

/**
 * Created : 2020-11-02 오전 8:25
 * Developer : Seo
 */
public class ResultView {

    public void print(Car car) {
        System.out.println((gridDistance(car.getDistance())));
    }

    private String gridDistance(int distance) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public void printTurnOver(int i) {
        System.out.println("turn " + i + " 종료");
        System.out.println();
    }
}
