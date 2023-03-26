package racing.domain;

import racing.Car;

import static racing.TheGame.random;

public class MoveCars {


    static int moveCars(Car[] cars) {
        int carPosistion = 0;

        for (Car car : cars) {
            /* carPosistion = Math.max(car.move(random.nextInt(10)), carPosistion);*/
            carPosistion = car.move(random.nextInt(10));
        }

        return carPosistion;
    }


}