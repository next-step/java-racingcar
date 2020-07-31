package camp.nextstep.edu.rebellion.racing;

import camp.nextstep.edu.rebellion.racing.rule.RacingRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EntryTest {
    private List<RacingCar> cars;

    @BeforeEach
    void setUp() {
        cars = new ArrayList<>();
        cars.add(new RacingCar("1"));
        cars.add(new RacingCar("2"));
        cars.add(new RacingCar("3"));
    }

    @DisplayName("Entry에 있는 자동차들이 잘 움직이는지 확인")
    @Test
    public void moveTest() {
        // given
        Entry entry = new Entry(cars);
        RacingRule alwaysGoRule = () -> true;
        String expectedLane = "-\n-\n-";

        // when
        entry.move(alwaysGoRule);

        // then
        assertThat(entry.getAllPositionLanes()).isEqualTo(expectedLane);
    }
}