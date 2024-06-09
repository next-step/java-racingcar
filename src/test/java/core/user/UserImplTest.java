package core.user;

import static org.assertj.core.api.Assertions.assertThat;

import core.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserImplTest {

  Util util = new Util();
  UserImpl userImpl = new UserImpl(util);

  @Test
  @DisplayName("자동차 이름 입력받기")
  void getCarNames() {
    // given
    String userCarNamesCmd = "pobi, woni, jun";
    List<String> expectedList = new LinkedList<>(Arrays.asList("pobi", "woni", "jun"));
    // when
    List<String> carNames = getCarNamesTemp(userCarNamesCmd);
    // then
    assertThat(carNames).isEqualTo(expectedList);
  }

  List<String> getCarNamesTemp(String userCarNamesCmd) {
    return userImpl.parseCarNames(userCarNamesCmd);
  }

  @Test
  @DisplayName("자동차 이름 받는 형식 성공 확인")
  void isUserCarNameCmdValidateSuccess() {
    // given
    String userInput = "pobi, woni, jun";
    //when
    Boolean result = userImpl.isUserCarNameCmdValidate(userInput);
    // then
    assertThat(result).isEqualTo(true);
  }

  @Test
  @DisplayName("자동차 이름 받기 실패, 콤마 미완성")
  void isUserCarNameCmdValidateFail() {
    // given
    String userInput = "pobi, woni, jun,";
    //when
    Boolean result = userImpl.isUserCarNameCmdValidate(userInput);
    // then
    assertThat(result).isEqualTo(false);
  }

  @Test
  @DisplayName("자동차 이름 받기 실패, 하나만 입력")
  void isUserCarNameCmdValidateFail2() {
    // given
    String userInput = "pobi";
    //when
    Boolean result = userImpl.isUserCarNameCmdValidate(userInput);
    // then
    assertThat(result).isEqualTo(false);
  }

  @Test
  @DisplayName("자동차 이름 받기 실패, 자동차 이름 공란")
  void isUserCarNameCmdValidateFail3() {
    // given
    String userInput = "pobi, , jun";
    // when
    Boolean result = userImpl.isUserCarNameCmdValidate(userInput);
    // then
    assertThat(result).isEqualTo(false);
  }

  @Test
  @DisplayName("자동차 이름이 전부 5글자 이하 성공.")
  void checkCarNameLengthSuccess() {
    // given
    List<String> carNames = new ArrayList<>(Arrays.asList("pobi", "hi"));
    // when
    Boolean result = userImpl.checkCarNameLength(carNames);
    // then
    assertThat(result).isEqualTo(true);
  }

  @Test
  @DisplayName("자동차 이름이 전부 5글자 이하 실패")
  void checkCarNameLengthFail() {
    // given
    List<String> carNames = new ArrayList<>(Arrays.asList("pobi", "woniiiiii"));
    // when
    Boolean result = userImpl.checkCarNameLength(carNames);
    // then
    assertThat(result).isEqualTo(false);
  }

  @Test
  @DisplayName("콤마 형식 정상")
  void checkCommaSuccess() {
    // given
    String userInput = "pobi, woni, jun";
    // when
    Boolean result = userImpl.checkComma(userInput);
    // then
    assertThat(result).isEqualTo(true);
  }

  @Test
  @DisplayName("콤마 시작 실패")
  void checkCommaFail() {
    // given
    String userInput = ", pobi, woni, jun";
    // when
    Boolean result = userImpl.checkComma(userInput);
    // then
    assertThat(result).isEqualTo(false);
  }

  @Test
  @DisplayName("콤마 종료 실패")
  void checkCommaFail2() {
    // given
    String userInput = "pobi, woni, jun,";
    // when
    Boolean result = userImpl.checkComma(userInput);
    // then
    assertThat(result).isEqualTo(false);
  }

  @Test
  @DisplayName("자동차 이름 파싱 성공")
  void parseCarNamesSuccess() {
    // given
    String userInput = "pobi, woni, jun";
    List<String> expectedList = new ArrayList<>(Arrays.asList("pobi", "woni", "jun"));
    // when
    List<String> result = userImpl.parseCarNames(userInput);
    //then
    assertThat(result).isEqualTo(expectedList);
  }

  @Test
  @DisplayName("게임 홧수 받아오기 성공")
  void getGameTimesSuccess() {
    // given
    String userGameTimesCmd = "5";
    // when
    Integer result = getGameTimesTemp(userGameTimesCmd);
    // then
    assertThat(result).isEqualTo(5);
  }

  @Test
  @DisplayName("게임 홧수 받아오기 실패, 음수")
  void getGameTimesFail() {
    // given
    String userGameTimesCmd = "-1";
    // when
    Integer result = getGameTimesTemp(userGameTimesCmd);
    // then
    assertThat(result).isNotEqualTo(5);
  }

  @Test
  @DisplayName("게임 홧수 받아오기 실패, 너무 큰 수")
  void getGameTimesFail2() {
    // given
    String userGameTimesCmd = "81273891273918273";
    // when
    Integer result = getGameTimesTemp(userGameTimesCmd);
    // then
    assertThat(result).isEqualTo(0);
  }

  Integer getGameTimesTemp(String userGameTimesCmd) {
    try {
      return Integer.parseInt(userGameTimesCmd);
    } catch (NumberFormatException e) {
      return 0;
    }
  }
}