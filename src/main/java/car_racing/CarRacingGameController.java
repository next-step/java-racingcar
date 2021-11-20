package car_racing;

public class CarRacingGameController {

    private static final MoveStrategy MOVE_STRATEGY = new RandomMoveStrategy();
    private static final InputView INPUT_VIEW = new InputView();
    private static final OutputView OUTPUT_VIEW = new OutputView();

    private final CarRacingResultHistory carRacingResultHistory;
    private Cars cars;
    private int numberOfRound;

    public CarRacingGameController() {
        this.carRacingResultHistory = new CarRacingResultHistory();
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
        String carNames = INPUT_VIEW.showMessageAndGetCarNames();
        int numberOfRoundInput = INPUT_VIEW.showMessageAndGetNumberOfRound();

        cars = new Cars(carNames);
        numberOfRound = numberOfRoundInput;
    }

    private void racingOneRound() {
        cars.playOneRound(MOVE_STRATEGY);
    }

    private void updateRacingResult() {
        carRacingResultHistory.update(cars);
    }

    private void closeGame() {
        OUTPUT_VIEW.showCarRacingGameOutput(carRacingResultHistory);
    }

}
