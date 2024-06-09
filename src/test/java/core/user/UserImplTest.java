package core.user;

import core.util.Util;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserImplTest {

  Util util = new Util();
  @Test
  @DisplayName("자동차 이름 입력받기")
  void getCarNames() {
    UserImpl userImpl = new UserImpl(util);
    // given
    // String userInput = "pobi, woni, jun";
    List<String> expectedList = new LinkedList<>(Arrays.asList("pobi", "woni", "jun"));
    // when
    List<String> carNames = getCarNames(userImpl);
    // then
    Assertions.assertThat(carNames).isEqualTo(expectedList);
  }

  @SuppressWarnings("StatementWithEmptyBody")
  List<String> getCarNames(UserImpl userImpl) {
    String userCarNamesCmd = "pobi, woni, jun";
    while (!userImpl.isUserCarNameCmdValidate((userCarNamesCmd))) {}

    return userImpl.parseCarNames(userCarNamesCmd);
  }
}