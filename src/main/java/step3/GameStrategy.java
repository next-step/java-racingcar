package step3;

public interface GameStrategy {

    int inputCar();

    int inputRetry();

    void playGame(int cars, int retry);

    void printCarStatus();

    default void start() {
        playGame(inputCar(), inputRetry());
    }

}
