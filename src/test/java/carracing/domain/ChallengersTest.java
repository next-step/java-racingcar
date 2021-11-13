package carracing.domain;

import carracing.domain.entity.Car;
import carracing.domain.entity.Challengers;
import carracing.domain.entity.Number;
import carracing.domain.entity.Participant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.function.BooleanSupplier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ChallengersTest {

  private static final int size = 3;
  private static final String names = "matt,pobbi,sup";
  private static final String COMMA = ",";
  private Challengers challengers;

  @BeforeEach
  void setUp() {
    challengers = new Challengers(Participant.of(names));
    for (int i = 0; i < size; i++) {
      String[] split = names.split(COMMA);
      challengers.register(new Car(split[i]));
    }
  }

  @ParameterizedTest
  @NullSource
  @DisplayName("생성자를 통해 참가자들을 입력받을 시 null 입력되면 Exception을 던진다.")
  void constructTest(Participant participant) {
    assertThatIllegalArgumentException().isThrownBy(() -> new Challengers(participant));
  }

  @ParameterizedTest
  @CsvSource(value = {"1:1", "4:2", "10:2"}, delimiter = ':')
  void startRoundTest(int input, int result) {
    for (Car car: challengers.startRound(isMoved(input))) {
        assertThat(car.getNowStep()).isEqualTo(result);
    }
  }

  BooleanSupplier isMoved(int a) {
    return () -> a > 3;
  }

}