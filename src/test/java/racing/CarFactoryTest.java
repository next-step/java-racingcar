package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.model.CarFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class CarFactoryTest {

  private CarFactory carFactory;

  @BeforeEach
  void setup() {
    carFactory = new CarFactory();
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 3, 100, 5000, 20000})
  @DisplayName("정상적인 대수가 생성되는지 확인")
  void makingTest(int insertingNum) {
    assertThat(carFactory.makeCars(insertingNum).getCars().size()).isEqualTo(insertingNum);
  }
}
