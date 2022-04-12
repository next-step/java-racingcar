package racingcar;

public class Controller {
    public static void main(String[] args) {
        InputView.askCarCount();
        int carCount = InputView.nextInt();
        Cars cars = new Cars(carCount);

        InputView.askTryCount();
        int playCount = InputView.nextInt();

        GameService.start(cars, playCount);
    }
}
