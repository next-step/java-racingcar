package racingcar;

public class Main {
    public static void main(String[] args) {
        int numOfCars = InputView.getNumOfCars();
        int tryingCount = InputView.getTryCount();

        RacingCarFactory factory = RacingCarFactory.getFactory(numOfCars, tryingCount);
        ResultView resultView = new ResultView(factory.manufactoringCars());
        resultView.printCars();

    }
}
