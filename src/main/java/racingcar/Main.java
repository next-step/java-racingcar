package racingcar;

public class Main {
    public static void main(String[] args) {
        String nameListOfCars = InputView.getNameListOfCars();
        int tryingCount = InputView.getTryingCount();

        CarGameInfo carGameInfo = new CarGameInfo(CarFactory.manufactoringCars(nameListOfCars, tryingCount));

        ResultView.printCars(carGameInfo, tryingCount);
        ResultView.printWinners(carGameInfo);
    }
}
