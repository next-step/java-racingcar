package carracing.domain;

import carracing.domain.entity.Car;
import carracing.domain.entity.Challengers;
import carracing.domain.entity.Participant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.ArrayList;
import java.util.function.BooleanSupplier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ChallengersTest {

  private static final int SIZE = 3;
  private static final String NAMES = "matt,pobbi,sup";
  private static final String COMMA = ",";
  private Challengers challengers;

  @BeforeEach
  void setUp() {
    challengers = new Challengers(Participant.parse(NAMES));
    for (int i = 0; i < SIZE; i++) {
      String[] split = NAMES.split(COMMA);
      challengers.register(new Car(split[i]));
    }
  }

  @ParameterizedTest
  @NullSource
  @DisplayName("생성자를 통해 참가자들을 입력받을 시 참가자가 null이면 Exception을 던진다.")
  void constructInputNullTestWithException(Participant participant) {
    assertThatIllegalArgumentException().isThrownBy(() -> new Challengers(participant));
  }

  @Test
  @DisplayName("생성자를 통해 참가자들을 입력받을 시 참가자의 수가 0이면 Exception을 던진다.")
  void constructInputZeroTestWithException() {
    assertThatIllegalArgumentException().isThrownBy(() -> new Challengers(new Participant(new ArrayList<>())));
  }

  @ParameterizedTest
  @CsvSource(value = {"1:1", "4:2", "10:2"}, delimiter = ':')
  void startRoundTest(int input, int result) {
    challengers.notifyCarOfStart(isMoved(input));
    for (Car car: challengers.getChallengers()) {
        assertThat(car.getNowStep()).isEqualTo(result);
    }
  }

  BooleanSupplier isMoved(int a) {
    return () -> a > 3;
  }

}