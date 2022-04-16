public class TrafficController {

  private static final String MESSAGE_FOR_INPUT_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
  private static final String MESSAGE_FOR_INPUT_TRY_COUNT = "시도할 대수는 몇 회 회가요?";
  private static final String POSITION_MARKER = "-";
  private static final String RESULT_GUIDE_MESSAGE = "실행결과";
  private static final int MAX_RANDOM_VALUE = 10;
  private static final int CAR_INITIAL_POSITION = 0;
  private static final int MIN_DISTANCE_TO_MOVE = 4;
  private static final int MIN_CAR_COUNT = 1;
  private static final int MIN_TRY_COUNT = 1;

  private final InputView inputView;
  private final OutputView outputView;

  private int carCount;
  private int tryCount;
  private Cars cars;


  private TrafficController() {
    this.inputView = new InputView();
    this.outputView = new OutputView();
  }

  public static TrafficController init() {
    return new TrafficController();
  }

  public TrafficController insertCarCount() {
    return carCount(inputView.scanInt(MESSAGE_FOR_INPUT_CAR_COUNT));
  }

  public TrafficController carCount(int carCount) {
    validateCarCount(carCount);
    this.carCount = carCount;
    return this;
  }

  public TrafficController createCars() {
    validateCarCount(carCount);
    this.cars = new Cars(
        this.carCount,
        CAR_INITIAL_POSITION,
        MIN_DISTANCE_TO_MOVE
    );
    return this;
  }

  public TrafficController insertTryCount() {
    return tryCount(inputView.scanInt(MESSAGE_FOR_INPUT_TRY_COUNT));
  }

  public TrafficController tryCount(int tryCount) {
    validateTryCount(tryCount);
    this.tryCount = tryCount;
    return this;
  }

  public void start() {
    validateBeforeStart();
    outputView.print(RESULT_GUIDE_MESSAGE);
    for (int i = 0; i < tryCount; i++) {
      cars.moveAllCar(MAX_RANDOM_VALUE);
      printResult();
      outputView.printEmpty();
    }
  }

  private void printResult() {
    cars.getPositions().forEach(count -> outputView.print(POSITION_MARKER, count));
  }

  private void validateCarCount(int carCount) {
    ArgumentValidator.validate(
        carCount,
        (arg) -> arg >= MIN_CAR_COUNT,
        String.format("차 갯수는 %d 이상이어야 합니다.", MIN_CAR_COUNT)
    );
  }

  private void validateTryCount(int tryCount) {
    ArgumentValidator.validate(
        tryCount,
        (arg) -> arg >= MIN_TRY_COUNT,
        String.format("시도 횟수는 %d 이상이어야 합니다.", MIN_TRY_COUNT)
    );
  }

  private void validateBeforeStart() {
    validateCarCount(carCount);
    validateTryCount(tryCount);
  }
}
