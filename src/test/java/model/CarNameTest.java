package model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNameTest {

  @DisplayName("CarName 생성에 성공한다.")
  @Test
  void CarName_성공() {
    String validName = "최대차이름";
    assertDoesNotThrow(() -> new CarName(validName));
  }

  @ParameterizedTest(name = "5자가 넘는 이름({0})으로 CarName 생성에 실패한다.")
  @ValueSource(strings = {"", " ", "여섯글자이름"})
  void CarName_실패(String invalidName) {
    assertThrows(IllegalArgumentException.class, () -> new CarName(invalidName));
  }
}
