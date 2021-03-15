import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class SetTest {

  private Set<Integer> numbers;

  @BeforeEach
  void setUp() {
    numbers = new HashSet<>();
    numbers.add(1);
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
  }

  @Test
  @DisplayName("올바르게 Set의 크기를 확인할 수 있는가")
  public void getSetSize() {
    //given
    int setSize = numbers.size();

    //when


    //then
    assertEquals(setSize, 3);
  }

  @ParameterizedTest
  @DisplayName("해당 값이 Set 내부에 존재하는가")
  @ValueSource(ints = {1, 2, 3})
  public void isContainedInSet(int testCase) {
    //given

    //when

    //then
    assertTrue(numbers.contains(testCase));
  }

  @ParameterizedTest
  @DisplayName("올바르지 않은 값에 대해서도 존재하는지 안하는지 판별가능한가")
  @CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
  public void isContainOrNot(String input, String expected) {
    //given
    boolean actualContains = numbers.contains(Integer.parseInt(input));

    //when
    boolean expectResult = Boolean.parseBoolean(expected);

    //then
    assertEquals(actualContains, expectResult);
  }

}