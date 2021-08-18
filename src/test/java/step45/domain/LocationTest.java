package step45.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LocationTest {

  @ParameterizedTest(name = "생성 테스트 : {0}")
  @ValueSource(ints = {1, 2, 3, 4, 20})
  void createTest(int location) {
    //when
    int actual = new Location(location).getLocation();

    //then
    assertThat(actual).isEqualTo(location);
  }

  @ParameterizedTest(name = "잘못된 생성 테스트 : {0}")
  @ValueSource(ints = {-1, -2, -20})
  void invalidTest(int location) {
    //then
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new Location(location);
    });
  }

  @ParameterizedTest(name = "위치값 증가 테스트 base:{0}, distance:{1}")
  @CsvSource({"1,3", "2,1", "3,10"})
  void increaseTest(int base, int distance) {
    //when
    Location location = new Location(base);
    Location increasedLocation = location.increase(distance);

    //then
    assertThat(increasedLocation).isEqualTo(new Location(base + distance));
  }
}