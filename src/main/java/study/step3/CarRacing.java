package study.step3;

public class CarRacing {

    private int round;
    private Car[] cars;

    public void startRacing() {
        initGameInput();
        playGame();
    }

    public void initGameInput() {
        InputView inputView = new InputView();

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
            printStateBoard();
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void printStateBoard() {
        for (Car car : cars) {
            System.out.println(printCarState(car.getPosition()));
        }
        System.out.println();
    }

    String printCarState(int position) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        CarRacing carRacing = new CarRacing();
        carRacing.startRacing();
    }

}
