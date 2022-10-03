package racingcar;

public class Main {
    public static void main(String[] args) {
        int numOfCars = InputView.getNumOfCars();
        int tryingCount = InputView.getTryingCount();

        ResultView resultView = new ResultView(RacingCarFactory.manufactoringCars(numOfCars, tryingCount));
        resultView.printCars();

    }
}
