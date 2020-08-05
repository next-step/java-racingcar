package step03.view;

import step03.util.Util;
import step03.car.Car;

/**
 * Project : java-racingcar
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 12:15 오전
 */
public class ResultView {

    public void draw(Car car) {
        for (int i = 0; i < car.getMoveCount(); i++) {
            System.out.println(Util.moveStirng);
        }
    }
}
