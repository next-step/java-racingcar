package step03;

import java.util.Map;

/**
 * Project : java-racingcar
 *
 * @author : jwdeveloper
 * @comment : InputView의 책임 : 그리는 역할
 * Time : 3:43 오후
 */
public class InputView {

    public void draw(final Map<Car, Integer> map) {

        for (final Car car: map.keySet()) {
            for (int i = 0; i < map.get(car); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }
}
