package controller;

import static uiview.InputView.scanInt;
import static uiview.InputView.scanString;
import static uiview.OutputView.print;
import static uiview.OutputView.printEmpty;

import domain.Cars;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import model.TryCount;
import uiview.OutputView;

public class TrafficController {

  private static final String ERROR_MESSAGE_OF_NON_CARS = "게임을 시작하기 위해서는 차를 입력해주세요";
  private static final String MESSAGE_FOR_INPUT_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
  private static final String MESSAGE_FOR_INPUT_TRY_COUNT = "시도할 대수는 몇 회 회가요?";
  private static final String CAR_RAW_NAMES_DELIMITER = ",";
  private static final String WINNERS_DELIMITER = ", ";
  private static final String MESSAGE_FOR_FINAL_RESULT = "%s가 최종 우승했습니다.";
  private static final String RESULT_GUIDE_MESSAGE = "실행결과";
  private static final int MAX_NUMBER_BOUND = 10;

  private TryCount tryCount;
  private Cars cars;


  private TrafficController() {
  }

  public static TrafficController init() {
    return new TrafficController();
  }

  public TrafficController createCarsByInsertingCarCount() {
    return createCars(scanString(MESSAGE_FOR_INPUT_CAR_COUNT));
  }

  public TrafficController createCars(String rawCarNames) {
    List<String> carNames = Stream.of(rawCarNames.split(CAR_RAW_NAMES_DELIMITER))
        .collect(Collectors.toUnmodifiableList());
    this.cars = new Cars(carNames);
    return this;
  }

  public TrafficController insertTryCount() {
    return tryCount(scanInt(MESSAGE_FOR_INPUT_TRY_COUNT));
  }

  public TrafficController tryCount(int tryCount) {
    this.tryCount = new TryCount(tryCount);
    return this;
  }

  public void start() {
    validateBeforeStart();
    print(RESULT_GUIDE_MESSAGE);

    do {
      cars.moveAllCarRandomly(MAX_NUMBER_BOUND);
      tryCount.race();
      List<String> currentPositionMark = cars.markingPositions();
      currentPositionMark.forEach(OutputView::print);
      printEmpty();
    } while (!tryCount.isFinished());

    print(buildFinalResult());
  }

  private String buildFinalResult() {
    return String.format(MESSAGE_FOR_FINAL_RESULT, getWinners());
  }

  private String getWinners() {
    StringJoiner stringJoiner = new StringJoiner(WINNERS_DELIMITER);
    cars.findWinners()
        .forEach(stringJoiner::add);
    return stringJoiner.toString();
  }



  private void validateBeforeStart() {
    Objects.requireNonNull(cars, ERROR_MESSAGE_OF_NON_CARS);
  }
}
