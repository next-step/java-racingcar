package step3;

public class CarRace {

    private final Cars cars;

    public CarRace(int carCount) {
        this.cars = new Cars(carCount);
    }

    public static void main(String[] args) {
        int carCount = InputView.inputCarCount();
        int moveCount = InputView.inputMoveCount();

        //자동차 경주 생성
        CarRace carRace = new CarRace(carCount);
    }
}
