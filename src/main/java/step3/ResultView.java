package step3;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

  private static final String NEWLINE = System.lineSeparator();
  private static final String NEWLINE_TWICE = NEWLINE.repeat(2);
  private static final String RESULT_VIEW_PREFIX = "실행 결과" + NEWLINE;
  private static final String RESULT_VIEW_SUFFIX = NEWLINE_TWICE;

  public void render(List<Result> results) {
    final String text = concat(results);
    print(text);
  }

  private void print(String text) {
    System.out.println(text);
  }

  protected String concat(List<Result> results) {
    return results.stream()
        .map(Result::log)
        .collect(Collectors.joining(NEWLINE_TWICE, RESULT_VIEW_PREFIX, RESULT_VIEW_SUFFIX))
        + winnerLog(results);
  }

  private String winnerLog(List<Result> results) {
    return results.get(results.size() - 1).winnerLog();
  }

}
