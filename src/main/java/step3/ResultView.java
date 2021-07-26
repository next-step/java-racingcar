package step3;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

  private static final String NEWLINE = System.lineSeparator();
  private static final String NEWLINE_TWICE = NEWLINE.repeat(2);
  private static final String NAME_LOCATION_DELIMITER = " : ";
  private static final String LOCATION_SIGN = "-";
  private static final String LOCATION_LOG_PREFIX = "실행 결과" + NEWLINE;
  private static final String LOCATION_LOG_SUFFIX = NEWLINE;
  private static final String WINNER_DELIMITER = ", ";
  private static final String WINNER_LOG_PREFIX = NEWLINE;
  private static final String WINNER_LOG_SUFFIX = "가 최종 우승했습니다.";

  private final List<Result> results;

  public ResultView(List<Result> results) {
    this.results = results;
  }

  public void render() {
    final String text = concat();
    print(text);
  }

  private void print(String text) {
    System.out.println(text);
  }

  protected String concat() {
    return locationLog() + winnerLog();
  }

  private String locationLog() {
    return results.stream()
        .map(result -> result.getCars().stream()
            .map(car -> car.getName() + NAME_LOCATION_DELIMITER + LOCATION_SIGN.repeat(car.getLocation()))
            .collect(Collectors.joining(NEWLINE))
        )
        .collect(Collectors.joining(NEWLINE_TWICE, LOCATION_LOG_PREFIX, LOCATION_LOG_SUFFIX));
  }

  private String winnerLog() {
    final int last = results.size() - 1;
    return results.get(last)
        .getWinners().stream()
        .collect(Collectors.joining(WINNER_DELIMITER, WINNER_LOG_PREFIX, WINNER_LOG_SUFFIX));
  }

}
