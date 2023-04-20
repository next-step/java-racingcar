package study.step4;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import study.domain.racingGame.CarNames;

public class CarNameTest {

  @DisplayName("생성 태스트")
  @Test
  public void createNameTest() {
    String[] name = {"a", "b", "c"};
    assertThat(new CarNames(name)).isInstanceOf(CarNames.class);
  }

  @DisplayName(" null이거나 비어있는 이름으로 생성 테스트")
  @ParameterizedTest
  @NullAndEmptySource
  public void createNameErrorTest(String[] inputNames) {
    CarNames names = new CarNames(inputNames);
    assertThat(names.isEmpty()).isTrue();
  }

  @DisplayName("비어있는 것을 체크하는 테스트")
  @Test
  public void emptyTest() {
    CarNames names = new CarNames();
    assertThat(names.isEmpty()).isTrue();
  }

  @DisplayName("이름 추가 테스트")
  @Test
  public void addTest() {
    CarNames names = new CarNames();
    names.addName("a");
    assertThat(names.isEmpty()).isFalse();
  }
}
