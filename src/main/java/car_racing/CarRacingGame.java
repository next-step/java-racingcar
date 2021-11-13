package car_racing;

public class CarRacingGame {

    private static final MoveStrategy moveStrategy = new RandomMoveStrategy();
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    private final CarRacingResult carRacingResult;
    private Cars cars;
    private int numberOfRound;

    public CarRacingGame() {
        this.carRacingResult = new CarRacingResult();
    }

    public void play() {
        initGame();

        for (int round = 0; round < numberOfRound; round++) {
            racingOneRound();
            updateRacingResult();

        }

        closeGame();
    }

    private void initGame() {
        int numberOfCarInput = inputView.showMessageAndGetNumberOfCars();
        int numberOfRoundInput = inputView.showMessageAndGetNumberOfRound();
        cars = new Cars(numberOfCarInput);
        numberOfRound = numberOfRoundInput;
    }

    private void racingOneRound() {
        cars.playOneRound(moveStrategy);
    }

    private void updateRacingResult() {
        carRacingResult.update(cars);
    }

    private void closeGame() {
        outputView.showCarRacingGameOutput(carRacingResult);
    }

}
