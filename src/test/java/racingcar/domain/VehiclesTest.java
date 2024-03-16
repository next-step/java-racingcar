package racingcar.domain;


import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VehiclesTest {

    @Test
    @DisplayName("레이싱 게임에 참여할 자동차들을 생성한다.")
    void racingGame() {
        //given
        List<String> name = List.of("pobi", "crong");

        //when
        Vehicles vehicles = new Vehicles(name);

        //then
        assertThat(vehicles.getVehicles().size()).isEqualTo(name.size());
    }

}