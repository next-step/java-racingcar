package racingGame.domain;

public interface Car {
    void move();

    long getTraceSize();

    String convertRound(String separator, String mark);

    String getCarName();

}
