package study.car.race;

public class Main {

    public static void main(String[] args) {
        int carCount = InputView.acceptCarCount();
        int tryCount = InputView.acceptTryCount();

        CarRace game = new CarRace(carCount);

        for (int i = 0; i < tryCount; i++) {
            game.race();
            ResultView.printResult(game.result());
        }
    }
}
