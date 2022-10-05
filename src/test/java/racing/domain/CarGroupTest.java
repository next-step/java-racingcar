package racing.domain;

import org.junit.jupiter.api.Test;
import racing.domain.car.Car;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CarGroupTest {

    @Test
    void 선두_그룹은_포지션이_앞선_그룹이다() {
        Car leader = new Car("a", 5);
        Car anotherLeader = new Car("b", 5);
        Car follower = new Car("c", 1);

        CarGroup carGroup = new CarGroup(Arrays.asList(leader, anotherLeader, follower));

        assertThat(carGroup.leadingGroup()).contains(leader, anotherLeader);
    }
}
