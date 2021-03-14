package RacingCar.service;

public interface GameService<T> {


    public void initGame();

    public void runStep();

    public Boolean isRunning();

    public T getGameInstance();
}
