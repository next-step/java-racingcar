package racingcar;

public class RacingApp {
    public static void main(String[] args) throws Exception {
        String[] carNames = InputView.getCarNames();
        int tryNumber = InputView.getTryNumber();
        Race race = new Race();
        race.createCars(carNumber);
        for (int i = 1; i <= tryNumber; i++) {
            ResultView.printResult(race.cars, i);
            race.rollCars();
        }
    }
}