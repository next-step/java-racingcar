package step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step4.controller.Game;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
  Game game;

  @BeforeEach
  void setup() {
    game = new Game();
  }

  @ParameterizedTest
  @CsvSource(value = {":3","      :2", ", ,  ,:5"}, delimiter = ':')
  @DisplayName("비정상적인 이름(NULL 혹은 빈 값)이 입력된 경우 제대로 종료하는지 확인")
  void invalidNullNameListTest(String carNames, int attempt){
    assertThat(game.run(carNames, attempt)).isEqualTo(false);
  }

  @ParameterizedTest
  @CsvSource(value = {"fsdafsdf,gsdgdsgf,sfeqfeqrtwr:3","assdfdsfg,gregrgr,ehgrtdhtfhfgthfgthjfgh:2", "asdfsdafgsdgsdgsdfg,xbdzfbfdb,dfhfdhfdhfdhdfas,:5"}, delimiter = ':')
  @DisplayName("5자를 초과하는 이름이 입력된 경우 제대로 종료하는지 확인")
  void invalidMaximumNameListTest(String carNames, int attempt){
    assertThat(game.run(carNames, attempt)).isEqualTo(false);
  }

  @ParameterizedTest
  @CsvSource(value = {"poa,pob,poc,pod:0", "poa,pob,poc,pod:0"}, delimiter = ':')
  @DisplayName("자동차 대수, 수행 횟수에 0 값이 들어올 경우 예외를 처리하는 지 여부 체크")
  void checkInvalidInputValueTest(String carNames, int attempt) {
    assertThat(game.run(carNames, attempt)).isEqualTo(false);
  }

  @ParameterizedTest
  @CsvSource(value = {"poa,pob,poc,pod:2", "aoa,aob,aoc,aod,aoe,aof:3"}, delimiter = ':')
  @DisplayName("자동차 이름, 수행 횟수가 정상적일 경우 게임을 제대로 수행하는지 여부 체크")
  void checkValidInputValueTest(String carNames, int attempt) {
    assertThat(game.run(carNames, attempt)).isEqualTo(true);
  }
}
