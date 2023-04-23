package study.step3;

import java.util.Random;

public class CarRacing {
    private static final int RANGE_FOR_RANDOM = 10;
    private Random random = new Random();
    private int round;
    private Cars cars;
    private InputView inputView;
    private ResultView resultView;

    public void startRacing() {
        inputView = new InputView();
        resultView = new ResultView();

        initGameInput();
        playGame();
        printWinner();

    }

    public void initGameInput() {
        initCarObject(inputView.readCarName());
        round = inputView.readGameRound();
    }

    private void initCarObject(String[] carNames) {
        cars = new Cars(carNames);

    }

    private void playGame() {
        System.out.println("실행 결과");
        for (int i = 0; i < round; i++) {
            moveCars();
            resultView.printStateBoard(cars);
        }
    }

    private void moveCars() {

        for (Car car : cars.asList()) {
            car.move(getRandomInt());
        }
    }

    int getRandomInt() throws IllegalArgumentException {
        return random.nextInt(RANGE_FOR_RANDOM);
    }

    private void printWinner() {
        resultView.printWinner(cars.findWinners());
    }

    public static void main(String[] args) {
        CarRacing carRacing = new CarRacing();
        carRacing.startRacing();
    }

}
