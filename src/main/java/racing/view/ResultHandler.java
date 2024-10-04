package racing.view;

import racing.car.Cars;

public interface ResultHandler {

    void winnerPrint(Cars winner);
    void endCycle();
    void racingPrint(Cars car);
}
