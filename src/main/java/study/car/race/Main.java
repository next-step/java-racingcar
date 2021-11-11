package study.car.race;

public class Main {

    public static void main(String[] args) {
        int carCount = InputView.acceptCarCount();
        int tryCount = InputView.acceptTryCount();

        CarRace.race(carCount, tryCount);
    }
}
