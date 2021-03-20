package racing.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.RacingCar;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class ListUtilsTest {

  @Test
  @DisplayName("문자열 리스트 변환 테스트")
  void of() {
    // given
    List<String> list = ListUtils.of("str", "str2");

    //
    System.out.println(list);
  }

  @Test
  @DisplayName("리스트 깊은 복사 테스트")
  void deepCopy() {
    // given
    List<RacingCar> list = Arrays.asList(RacingCar.create("gmoon"));

    // when
    List<RacingCar> result = ListUtils.deepCopy(list);

    // then
    assertAll(() -> assertThat(System.identityHashCode(result)).isNotEqualTo(System.identityHashCode(list))
            , () -> assertThat(result).containsAll(list));
  }

  @Test
  @DisplayName("리스트 깊은 복사 테스트, 리스트 요소들도 새로운 주소 값으로 할당되는지")
  void deepCopyShouldElementCopy() {
    // given
    RacingCar gmoon = RacingCar.create("gmoon");
    List<RacingCar> origin = Arrays.asList(gmoon);
    List<RacingCar> deepCopyList = ListUtils.deepCopy(origin);

    // when
    gmoon.move(() -> true);

    // then
    assertThat(deepCopyList.get(0).position())
            .isZero();
  }
}