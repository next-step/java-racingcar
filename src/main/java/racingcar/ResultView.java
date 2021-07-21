package racingcar;

import java.util.List;
import java.util.Random;

/*
 * 자동차 경주 결과 View
 */
public class ResultView {

    private static final int MAX_VALUE = 10;

    public void print(int move) {
        for (int i = 0; i < move; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printAll(List<Car> cars) {
        for(Car car: cars) {
            Random random = new Random();
            int randomNumber = random.nextInt(MAX_VALUE);
            int moveNumber = car.move(randomNumber);
            //3회
            print(moveNumber);
        }
    }


}
