package racingcar;

public class Main {
    public static void main(String[] args) {
        int carNum = InputView.readCarNum();
        int tryNum = InputView.readTryNum();

        Race race = new Race(carNum, tryNum);
        RaceResult result = race.play();

        OutputView.printResult(result);
    }
}
