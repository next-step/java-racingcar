package study.step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.domain.racingGame.Cars;
import study.domain.racingGame.GameBoard;

public class GameBoardTest {

  private GameBoard gameBoard;
  private Cars cars;

  @BeforeEach
  void setUp() {
    this.cars = new Cars(3);
    this.gameBoard = new GameBoard(this.cars);
  }

  @DisplayName("복사 테스트 ")
  @Test
  public void cloneTest() {
    assertThat(this.gameBoard.clone()).isNotEqualTo(this.gameBoard);
  }

  @DisplayName("결과 조회 테스트")
  @ParameterizedTest
  @CsvSource(value = {"0,0", "1,0", "2,0"})
  public void resultTest(int carNum, int result) {
    assertThat(this.gameBoard.getResult(carNum)).isEqualTo(result);
  }

  @DisplayName("결과 조회 에러 테스트 ")
  @Test
  public void resultErrorTest() {
    assertThatThrownBy(() -> this.gameBoard.getResult(4))
        .isInstanceOf(RuntimeException.class)
        .hasMessageContaining("해당 자동차가 존재하지 않습니다.");
  }

  @DisplayName("결과 조회 테스트")
  @ParameterizedTest
  @CsvSource(value = {"0,1", "1,1", "2,1"})
  public void updateTest(int carNum, Integer result) {
    this.cars.moveAll();
    this.gameBoard.updateResult(this.cars);
    assertThat(this.gameBoard.getResult(carNum)).isLessThanOrEqualTo(result);
  }
}
