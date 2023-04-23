package study.step3;

import java.util.ArrayList;
import java.util.Random;

public class CarRacing {
    private static final int RANGE_FOR_RANDOM = 10;
    private Random random = new Random();
    private int round;
    private Car[] cars;
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
        cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
    }

    private void playGame() {
        System.out.println("실행 결과");
        for (int i = 0; i < round; i++) {
            moveCars();
            resultView.printStateBoard(cars);
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move(getRandomInt());
        }
    }

    int getRandomInt() throws IllegalArgumentException {
        return random.nextInt(RANGE_FOR_RANDOM);
    }

    private void printWinner() {
        resultView.printWinner(findWinners());
    }

    private String findWinners() {

        Position carMaxPosition = findCarMaxPosition(cars);
        ArrayList<Name> names = findWinnerNames(cars, carMaxPosition);
        String winnerNames = "";

        for (int i = 0; i < names.size(); i++) {
            winnerNames += names.get(i);
            if (i == names.size() - 1) break;
            winnerNames += ",";
        }

        return winnerNames;
    }

    Position findCarMaxPosition(Car[] cars) {
        Position maxPosition = new Position(0);
        for (Car car : cars) {
            if(car.isBiggerPosition(maxPosition)) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    ArrayList<Name> findWinnerNames(Car[] cars, Position maxPosition) {
        ArrayList<Name> winnerNames = new ArrayList<>();

        for (Car car : cars) {
            if (!car.isCarPosition(maxPosition)) {
                continue;
            }
            winnerNames.add(car.getName());
        }
        return winnerNames;
    }


    public static void main(String[] args) {
        CarRacing carRacing = new CarRacing();
        carRacing.startRacing();
    }

}
