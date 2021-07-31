package racingcar;

public class Main {
    public static void main(String[] args) {
        String[] names = InputView.readCarNames();
        int tryNum = InputView.readTryNum();

        Cars cars = new Cars(names);
        Race race = new Race(cars, tryNum, new RandomRaceStrategy());
        RaceResult result = race.play();

        OutputView.printResult(result);
    }
}
