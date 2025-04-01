package step3;

public class CarRace {

    private final Cars cars;

    public CarRace(int carCount) {
        this.cars = new Cars(carCount);
    }

    public void start(int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            this.cars.playRound();
        }
    }

    private void print(int moveCount) {
        cars.print(moveCount);
    }

    public static void main(String[] args) {
        int carCount = InputView.inputCarCount();
        int moveCount = InputView.inputMoveCount();

        //자동차 경주 생성
        CarRace carRace = new CarRace(carCount);

        //자동차 경주 시작
        carRace.start(moveCount);

        //출력
        carRace.print(moveCount);
    }
}
