package step3.service;

import step3.domain.InputCar;

public interface GameStrategy {

    InputCar input();

    void playGame(InputCar inputCar);

    void printCarStatus();

    default void start() {
        playGame(input());
    }

}
