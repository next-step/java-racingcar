package step4_winner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


class RaceTest {

    @Test
    @DisplayName("레이스에는 1대 이상의 차가 필요하다.")
    void raceMustPositiveCars(){
        // GIVEN empty list
        List<Car> cars = new ArrayList<>();
        // WHEN create
        Throwable illegalThrown = catchThrowable(() -> new Race(cars));
        // THEN
        assertThat(illegalThrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0이상이어야 함");

        // GIVEN positive
        cars.add(new Car("test1"));
        // WHEN
        Race legalRace = new Race(cars);
        // THEN
        assertThat(legalRace).isNotNull();
    }

}