package racinggame.domain.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.value.Location;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParticipantsTest {

    @Test
    @DisplayName("참가자들이 모두 한 라운드를 수행한 결과를 확인한다.")
    void play() {
        String car1 = "car1";
        String car2 = "car2";
        List<Car> cars = Arrays.asList(new Car(car1), new Car(car2));
        Participants participants = new Participants(cars);
        List<Location> locations = participants.play(() -> true);

        assertEquals(Arrays.asList(new Location(car1, 1), new Location(car2, 1)), locations);
    }
}