package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParticipantsTest {

  private Participants participants;
  private List<String> carNames;

  @BeforeEach
  void init() {
    carNames = List.of("a", "b", "c");
    participants = Participants.from(carNames);
  }

  @Test
  @DisplayName("모든 차가 움직이지 않으면 모두가 우승자")
  void allWinnersWhenNoOneMovies() {
    MovementStrategy noMoveStrategy = new MovementStrategy(0, 0);
    participants.play(noMoveStrategy);

    List<String> winners = participants.getWinnerNames();
    assertThat(winners).containsExactlyInAnyOrder("a", "b", "c");
  }

  @Test
  @DisplayName("가장 멀리 이동한 차만 우승자")
  void onlyMaxPositionCarIsWinner() {
    List<Car> cars = List.of(
        new Car("a", 5),
        new Car("b", 3),
        new Car("c", 2)
    );
    Participants customParticipants = new Participants(cars);

    List<String> winners = customParticipants.getWinnerNames();
    assertThat(winners).containsExactly("a");
  }

  @Test
  @DisplayName("같은 최대 위치에 있는 차들이 모두 우승자")
  void multipleWinnersWhenTied() {
    List<Car> cars = List.of(
        new Car("a", 5),
        new Car("b", 5),
        new Car("c", 2)
    );
    Participants customParticipants = new Participants(cars);

    List<String> winners = customParticipants.getWinnerNames();
    assertThat(winners).containsExactlyInAnyOrder("a", "b");
  }

  @Test
  @DisplayName("'이름 : 위치' 형식으로 출력")
  void toStringFormat() {
    String result = participants.toString();
    assertThat(result).matches("^([\\w]+ : -*\\n)+$");
  }
}