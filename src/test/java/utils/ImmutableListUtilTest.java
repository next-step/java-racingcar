package utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.ImmutableListUtils;

public class ImmutableListUtilTest {

  @Test
  @DisplayName("[ImmutableListUtils.appendOneWith()] 불변 리스트에서 원소 하나를 추가하여 새로운 리스트를 반환한다.")
  public void 불변_리스트에_원소_추가_후_새로운_리스트_반환() {
    // given
    final List<Integer> 입력 = List.of(1, 2);
    final List<Integer> 예샹결과 = List.of(1, 2, 3);

    // when
    final List<Integer> 결과 = ImmutableListUtils.appendOneWith(입력, 3);

    // then
    assertThat(결과).containsExactlyElementsOf(예샹결과);
  }

  @Test
  @DisplayName("[ImmutableListUtils.appendOneWith()] null인 리스트에는 요소를 추가 할 수 없다.")
  public void null인_리스트에는_요소_추가_불가능() {
    // given
    final List<Integer> 입력 = null;

    // when && then
    assertThatThrownBy(() -> ImmutableListUtils.appendOneWith(입력, 3))
        .isInstanceOf(NullPointerException.class)
        .hasMessageContaining("null인 list에는 append 할 수 없습니다.");
  }

  @Test
  @DisplayName("[ImmutableListUtils.appendOneWith()] null을 리스트에 추가 할 수 없다.")
  public void null은_리스트에는_추가_불가능() {
    // given
    final List<Integer> list = List.of(1,2,3);

    // when && then
    assertThatThrownBy(() -> ImmutableListUtils.appendOneWith(list, null))
        .isInstanceOf(NullPointerException.class)
        .hasMessageContaining("null을 append 할 수 없습니다.");
  }

  @Test
  @DisplayName("[ImmutableListUtils.appendOneWith()] 비어있는 리스트에는 요소를 추가 할 수 있다.")
  public void empty_리스트에는_요소_추가_가능() {
    // given
    final List<Integer> 입력 = Collections.emptyList();
    final List<Integer> 예샹결과 = List.of(3);

    // when
    final List<Integer> 결과 = ImmutableListUtils.appendOneWith(입력, 3);

    // then
    assertThat(결과).containsExactlyElementsOf(예샹결과);
  }
}
