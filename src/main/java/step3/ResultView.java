package step3;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

  public static final String NEWLINE_TWICE = "\n\n";

  public void render(List<Result> results) {
    final String text = concat(results);

    final String consoleLog = new StringBuilder("실행 결과").append("\n")
        .append(text).toString();

    print(consoleLog);
  }

  private void print(String text) {
    System.out.println(text);
  }

  protected String concat(List<Result> results) {
    return results.stream()
        .map(Result::log)
        .collect(Collectors.joining(NEWLINE_TWICE));
  }
}
