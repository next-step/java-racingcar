package racingCar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TrackTest {

  private Track track;
  @BeforeEach
  void init() {
    track = new Track();
  }

  @Test
  @DisplayName("몇 대의 차량과 경주를 할지 테스트한다.")
  void countTest() {
    List<Car> cars = track.vehiclesCount(3);
    assertThat(cars.size()).isEqualTo(3);
  }
}