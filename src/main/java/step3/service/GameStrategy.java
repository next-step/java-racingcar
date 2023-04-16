package step3.service;

import step3.domain.UserInput;

public interface GameStrategy {

    UserInput input();

    void playGame(UserInput userInput);

    void printCarStatus();

    default void start() {
        playGame(input());
    }

}
