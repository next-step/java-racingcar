package controller;

import domain.Cars;
import java.util.Objects;
import model.CarCount;
import model.TryCount;
import uiview.InputView;
import uiview.OutputView;

public class TrafficController {

  private static final String MESSAGE_FOR_UNABLE_TO_START = "준비 데이터가 충분하지 않아 게임을 시작할 수 없습니다.";
  private static final String MESSAGE_FOR_INPUT_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
  private static final String MESSAGE_FOR_INPUT_TRY_COUNT = "시도할 대수는 몇 회 회가요?";
  private static final String POSITION_MARKER = "-";
  private static final String RESULT_GUIDE_MESSAGE = "실행결과";
  private static final int MAX_NUMBER_BOUND = 10;

  private final InputView inputView;
  private final OutputView outputView;

  private TryCount tryCount;
  private Cars cars;


  private TrafficController() {
    this.inputView = new InputView();
    this.outputView = new OutputView();
  }

  public static TrafficController init() {
    return new TrafficController();
  }

  public TrafficController createCarsByInsertingCarCount() {
    return createCars(new CarCount(inputView.scanInt(MESSAGE_FOR_INPUT_CAR_COUNT)));
  }

  public TrafficController createCars(CarCount carCount) {
    validateCarCount(carCount);
    this.cars = new Cars(carCount.getValue());
    return this;
  }

  public TrafficController insertTryCount() {
    return tryCount(inputView.scanInt(MESSAGE_FOR_INPUT_TRY_COUNT));
  }

  public TrafficController tryCount(int tryCount) {
    this.tryCount = new TryCount(tryCount);
    return this;
  }

  public void start() {
    validateBeforeStart();
    outputView.print(RESULT_GUIDE_MESSAGE);
    for (int i = 0; i < tryCount.getValue(); i++) {
      cars.moveAllCarRandomly(MAX_NUMBER_BOUND);
      tryCount.race();
      printResult();
      outputView.printEmpty();
    }
  }

  private void printResult() {
    cars.getPositions().forEach(count -> outputView.print(POSITION_MARKER, count));
  }

  private void validateCarCount(CarCount carCount) {
    Objects.requireNonNull(carCount);
  }

  private void validateTryCount(TryCount tryCount) {
    Objects.requireNonNull(tryCount);
    tryCount.validate();
  }

  private void validateBeforeStart() {
    try {
      Objects.requireNonNull(cars);
      cars.validate();
      validateTryCount(tryCount);
    } catch (Exception e) {
      outputView.print(MESSAGE_FOR_UNABLE_TO_START);
    }
  }
}
