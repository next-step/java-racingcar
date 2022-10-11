package racingCar;

public class RacingCarController {

    private RacingCar[] racingCars;

    private InputView inputView;
    private ResultView resultView;

    private int carCnt;
    private int moveCnt;

    public RacingCarController() {
        inputView = new InputView();
        resultView = new ResultView();

        inputView.scan();

        racingCars = new RacingCar[inputView.carCnt()];
        for (int carIndex = 0; carIndex < racingCars.length; carIndex++) {
            racingCars[carIndex] = new RacingCar();
        }

        carCnt = inputView.carCnt();
        moveCnt = inputView.moveCnt();
    }

    public RacingCarController(RacingCar[] racingCars, InputView inputView, ResultView resultView) {
        this.racingCars = racingCars;
        this.inputView = inputView;
        this.resultView = resultView;
    }

    private void raceOnce() {

        for (int carIndex = 0; carIndex < carCnt; carIndex++) {
            racingCars[carIndex].race();
        }

        resultView.printCarsDistance(racingCars);
    }

    public void race() {

        resultView.printTitle();

        for (int raceIndex = 0; raceIndex < moveCnt; raceIndex++) {
            raceOnce();
        }
    }
}
