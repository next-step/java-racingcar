package study.step3;

public class CarRacing {

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
            car.move();
        }
    }

    private void printWinner() {
        resultView.printWinner(findWinners());
    }

    private String findWinners() {
        int carMaxPosition = findCarMaxPosition(cars);
        return findWinnerNames(cars, carMaxPosition);
    }

    public int findCarMaxPosition(Car[] cars) {
        int maxPosition = 0;
        for(Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public String findWinnerNames(Car[] cars, int maxPosition) {
        String winnerNames = "";
        for(Car car : cars) {
            winnerNames = findCarNamesThatPosition(winnerNames, car, maxPosition);
        }
        return winnerNames;
    }

    private String findCarNamesThatPosition(String winnerNames, Car car, int position) {
        if (car.getPosition() != position) {
            return winnerNames;
        }

        if(winnerNames.length() == 0) {
            return car.getName();
        }

        return winnerNames + "," + car.getName();
    }

    public static void main(String[] args) {
        CarRacing carRacing = new CarRacing();
        carRacing.startRacing();
    }

}
