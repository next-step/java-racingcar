package step3;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResultViewTest {

  public static final String NEWLINE = System.lineSeparator();

  private ResultView resultView;

  @BeforeEach
  void init() {
    resultView = new ResultView(of(
        new Result(of(car("pobi", 1), car("crong", 1), car("honux", 1))),
        new Result(of(car("pobi", 2), car("crong", 1), car("honux", 2))),
        new Result(of(car("pobi", 3), car("crong", 2), car("honux", 3))),
        new Result(of(car("pobi", 4), car("crong", 3), car("honux", 4))),
        new Result(of(car("pobi", 5), car("crong", 4), car("honux", 5))),
        new Result(of(car("pobi", 5), car("crong", 4), car("honux", 5)))
    ));
  }

  @Test
  void concat() {
    final String actual = resultView.concat();

    final String expected = "실행 결과" + NEWLINE
        + "pobi : -" + NEWLINE
        + "crong : -" + NEWLINE
        + "honux : -" + NEWLINE
        + "" + NEWLINE
        + "pobi : --" + NEWLINE
        + "crong : -" + NEWLINE
        + "honux : --" + NEWLINE
        + "" + NEWLINE
        + "pobi : ---" + NEWLINE
        + "crong : --" + NEWLINE
        + "honux : ---" + NEWLINE
        + "" + NEWLINE
        + "pobi : ----" + NEWLINE
        + "crong : ---" + NEWLINE
        + "honux : ----" + NEWLINE
        + "" + NEWLINE
        + "pobi : -----" + NEWLINE
        + "crong : ----" + NEWLINE
        + "honux : -----" + NEWLINE
        + "" + NEWLINE
        + "pobi : -----" + NEWLINE
        + "crong : ----" + NEWLINE
        + "honux : -----" + NEWLINE
        + "" + NEWLINE
        + "pobi, honux가 최종 우승했습니다.";

    assertThat(actual).isEqualTo(expected);
  }

  private Car car(String name, int location) {
    return new Car(new Name(name), location);
  }

}