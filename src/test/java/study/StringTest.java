package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2021/03/02.
 * @project java-racingcar
 * @description
 */
public class StringTest {
  @Test
  void split() {
    String[] result = "1,2".split(",");
    assertThat(result).containsExactly("1","2");
  }

}
