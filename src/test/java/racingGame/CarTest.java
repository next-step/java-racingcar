package racingGame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import javafx.util.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingGame.racingGameException.IllegalCarNameLengthException;

class CarTest {

  private Car sampleCar;

  @BeforeEach
  void setUp(){
    this.sampleCar = Car.of("ABC");
  }

  @Test
  @DisplayName("null 형식의 이름 지정")
  void InvalidNullInstance() {
    assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
        () -> Car.of(null)
    );
  }

  @Test
  @DisplayName("empty 형식의 이름 지정")
  void InvalidEmptyInstance() {
    assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
        () -> Car.of("")
    );
  }

  @Test
  @DisplayName("긴 이름의 Car 이름")
  void veryLongNameCar() {
    assertThatExceptionOfType(IllegalCarNameLengthException.class).isThrownBy(
        () -> Car.of("DONSIX")
    );
  }

  @Test
  @DisplayName("움직임 테스트")
  void moveExactly() {
    ScoreGenerator scoreGenerator = () -> 1;

    assertThat(this.sampleCar.move(scoreGenerator)).isEqualTo(1);
  }

  @Test
  @DisplayName("이름 위치 형식 출력")
  void nameAndPosition(){
    assertThat(this.sampleCar.publishNamePosition())
        .isEqualTo(new Pair<>("ABC", 0));
  }

  @Test
  @DisplayName("이름 단독 출력")
  void printOnlyName(){
    assertThat(this.sampleCar.getName()).isEqualTo("ABC");
  }
}
