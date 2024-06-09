package core.user;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserImplTest {

  @Test
  @DisplayName("자동차 이름 입력받기")
  void getCarNames() {
    UserImpl userImpl = new UserImpl();
    // given
    String userInput = "pobi, woni, jun";
    List<String> expectedList = new LinkedList<String>(Arrays.asList("pobi", "woni", "jun"));
    // when
    List<String> carNames = dd(userImpl);
    // then
    Assertions.assertThat(carNames).isEqualTo(expectedList);
  }

  List<String> dd(UserImpl userImpl) {
    String userCarNamesCmd = "pobi, woni, jun";
    do {
    } while (!userImpl.isUserCarNameCmdValidate((userCarNamesCmd)));

    return userImpl.parseCarNames(userCarNamesCmd);
  }
}