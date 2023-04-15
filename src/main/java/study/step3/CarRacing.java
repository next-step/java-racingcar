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
        resultView.printWinner(cars);
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

    public static void main(String[] args) {
        CarRacing carRacing = new CarRacing();
        carRacing.startRacing();
    }

}
