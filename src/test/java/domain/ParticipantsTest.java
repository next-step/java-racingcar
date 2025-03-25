package domain;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantsTest {

    @Test
    public void getWinner는_가장_position이_큰_carList를_반환한다(){
        List<Car> carList = List.of(
            new Car("a", 1),
            new Car("b", 2),
            new Car("c", 3),
            new Car("d", 4),
            new Car("e", 4)
        );

        Participants participants = new Participants(carList);
        assertThat(participants.getWinner())
            .allMatch(car -> car.getCurrentPosition() == 4);
    }
}
