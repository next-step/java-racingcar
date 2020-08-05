package step03;

import java.util.Iterator;
import java.util.Map;

/**
 * Project : java-racingcar
 *
 * @author : jwdeveloper
 * @comment : Racing의 책임 : 차를 경주에 대한 값을 계산
 * Time : 9:23 오후
 */
public class Racing {

    private int randomNum;

    public Map<Car, Integer> race(final int numberOfCars, final int numberOfAttempts) {
        final Car car = new Car();
        final InputView inputView = new InputView();
        Map<Car, Integer> carMap = car.initCar(numberOfCars);
        Iterator<Car> keys;

        calculateRacing(numberOfAttempts, inputView, carMap);

        return carMap;
    }

    private void calculateRacing(final int numberOfAttempts, final InputView inputView, final Map<Car, Integer> carMap) {
        Iterator<Car> keys;
        for (int i = 0; i < numberOfAttempts; i++) {
            keys = carMap.keySet().iterator();

            while (keys.hasNext()) {
                Car nextCar = keys.next();
                randomNum = (int) ((Math.random() * 10000) % 10);
                if (randomNum >= 4) {
                    carMap.put(nextCar, carMap.get(nextCar) + 1);
                }
            }

            inputView.draw(carMap);
            System.out.println();
        }
    }
    
}
