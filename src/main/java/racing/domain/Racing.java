package racing.domain;

import racing.Car;

import static racing.domain.MoveCars.moveCars;

public class Racing {

    public static int racing(int rd, Car[] cs) {
        int maxPosition = 0;
        int round = rd;
        Car[] cars = cs;

        for (int i = 0; i < round; i++) {
            maxPosition = Math.max(moveCars(cars), maxPosition);
        }

        return maxPosition;
    }
}
