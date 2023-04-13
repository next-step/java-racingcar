package racingcar;

public class GameService {
    private int carNumber;
    private int trialNumber;
    private MoveStrategy moveStrategy = new FourOverTenMoveStrategy();

    public GameService(int carNumber, int trialNumber) {
        this.carNumber = carNumber;
        this.trialNumber = trialNumber;
    }

    public void play(){
        CarCollection cars = new CarCollection(this.carNumber, moveStrategy);
        tryMoves(cars, this.trialNumber);
    }

    private void tryMoves(CarCollection cars, int trialNumber) {

        for (int i = 0; i< trialNumber; i++) {
            cars.tryMove();
            //resultView.printResult(cars.getPositionList());
        }
    }
}
