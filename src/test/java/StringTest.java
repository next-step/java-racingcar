import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {

  @Test
  @DisplayName("입력 값이 콤마(,)로 제대로 split 되는가")
  public void split() {
    //given
    final String TEST_CASE_1 = "1,2";
    final String TEST_CASE_2 = "1";

    //when
    String[] actualCaseOneResult = TEST_CASE_1.split(",");
    String[] actualCaseTwoResult = TEST_CASE_2.split(",");

    String[] expectedCaseOneResult = {"1","2"};
    String[] expectedCaseTwoResult = {"1"};

    //then
    assertAll("String Split Test",
        () -> assertArrayEquals(actualCaseOneResult, expectedCaseOneResult),
        () -> assertArrayEquals(actualCaseTwoResult, expectedCaseTwoResult)
    );
  }

  @Test
  @DisplayName("substring() 메소드를 활용하여 괄호를 제거 하여 문자열의 숫자 값만 구할 수 있는가")
  public void removeBracket() {
    //given
    final String TEST_CASE = "(1,2)";

    //when
    String actualSubstring = TEST_CASE.substring(1, TEST_CASE.length() - 1);
    String expectedSubstring = "1,2";

    //then
    assertEquals(actualSubstring, expectedSubstring);
  }

  @Test
  @DisplayName("charAt() 메소드를 통하여 특정 위치의 문자를 가져올 수 있는가")
  public void getCharacterFromIndex() {
    //given
    final String TEST_CASE = "abc";

    Random random = new Random();
    random.setSeed(System.currentTimeMillis());
    int index = random.nextInt(4);

    //when
    if(index > TEST_CASE.length() -1) {

      Throwable thrown = assertThrows(StringIndexOutOfBoundsException.class, () -> {
        throw new StringIndexOutOfBoundsException("문자열의 크기를 초과하였습니다.");
      });
      //then
      assertEquals(thrown.getMessage(), "문자열의 크기를 초과하였습니다.");
    } else {
      //when
      char actualCaseResult = TEST_CASE.charAt(index);

      //then
      assertTrue(TEST_CASE.contains(String.valueOf(actualCaseResult)));
    }
  }
}