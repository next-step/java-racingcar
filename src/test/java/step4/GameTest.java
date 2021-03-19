package step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step4.controller.Game;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameTest {
  private Game game;

  @BeforeEach
  void setup() {
    game = new Game();
  }

  @ParameterizedTest
  @CsvSource(value = {":3", "      :2"}, delimiter = ':')
  @DisplayName("NULL 혹은 빈 값이 입력된 경우 제대로 종료하는지 확인")
  void invalidNullStringTest(String carNames, int attempt) {
    assertThatExceptionOfType(IllegalArgumentException.class)
      .isThrownBy(() -> {
        game.run(carNames, attempt);
      }).withMessageMatching("입력된 차량들의 전체 이름이 잘못 되었습니다.");
  }

  @ParameterizedTest
  @CsvSource(value = {"fdsa, ,fsd,:5"}, delimiter = ':')
  @DisplayName("요소 내에서 빈 값이 입력된 경우 제대로 종료하는지 확인")
  void invalidNullNameListTest(String carNames, int attempt) {
    assertThatExceptionOfType(IllegalArgumentException.class)
      .isThrownBy(() -> {
        game.run(carNames, attempt);
      }).withMessageMatching("입력된 차량들의 이름을 확인하세요. 1~5자 허용입니다.");
  }

  @ParameterizedTest
  @CsvSource(value = {"fsdafsdf,gsdgdsgf,sfeqfeqrtwr:3", "assdfdsfg,gregrgr,ehgrtdhtfhfgthfgthjfgh:2", "asdfsdafgsdgsdgsdfg,xbdzfbfdb,dfhfdhfdhfdhdfas,:5"}, delimiter = ':')
  @DisplayName("5자를 초과하는 이름이 입력된 경우 제대로 종료하는지 확인")
  void invalidMaximumNameListTest(String carNames, int attempt) {
    assertThatThrownBy(() -> {
      game.run(carNames, attempt);
    }).isInstanceOf(IllegalArgumentException.class)
      .withFailMessage("입력된 차량들의 이름을 확인하세요. 1~5자 허용입니다.");
  }

  @ParameterizedTest
  @CsvSource(value = {"poa,pob,poc,pod:0", "poa,pob,poc,pod:0"}, delimiter = ':')
  @DisplayName("자동차 대수, 수행 횟수에 0 값이 들어올 경우 예외를 처리하는 지 여부 체크")
  void checkInvalidInputValueTest(String carNames, int attempt) {
    assertThatExceptionOfType(IllegalArgumentException.class)
      .isThrownBy(() -> {
        game.run(carNames, attempt);
      }).withMessageMatching("입력된 경주 횟수를 확인하세요.");
  }

  @ParameterizedTest
  @CsvSource(value = {"poa,pob,poc,pod:2", "aoa,aob,aoc,aod,aoe,aof:3"}, delimiter = ':')
  @DisplayName("자동차 이름, 수행 횟수가 정상적일 경우 게임을 제대로 수행하는지 여부 체크")
  void checkValidInputValueTest(String carNames, int attempt) {
    game.run(carNames, attempt);
  }
}