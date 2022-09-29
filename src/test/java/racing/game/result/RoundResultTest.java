package racing.game.result;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.game.Car;

import static org.assertj.core.api.Assertions.assertThat;

class RoundResultTest {

    @ParameterizedTest
    @ValueSource(ints = { 3, 4, 5, 6 })
    void 자동차의_현재_위치를_저장할_수_있다(int carPosition) {
        Car car = new Car("name", limit -> 10);
        for (int i = 0; i < carPosition; i++) {
            car.move();
        }

        RoundResult sut = new RoundResult();
        sut.addCarRoundResult(car);

        assertThat(sut.positionOfCar("name")).isEqualTo(carPosition);
    }


    @Test
    void 현_라운드의_선두그룹을_파악할_수_있다() {
        RoundResult sut = new RoundResult();

        Car follower = new Car("follower", limit -> 0);
        Car leader = new Car("leader", limit -> 10);
        Car anotherLeader = new Car("anotherLeader", limit -> 10);

        runRounds(sut, follower, leader, anotherLeader);

        assertThat(sut.nameOfLeadingGroup()).contains("leader", "anotherLeader");
    }


    private void runRounds(RoundResult sut, Car follower, Car leader, Car anotherLeader) {
        for (int i = 0; i < 10; i++) {
            follower.move();
            leader.move();
            anotherLeader.move();
        }

        sut.addCarRoundResult(follower);
        sut.addCarRoundResult(leader);
        sut.addCarRoundResult(anotherLeader);
    }

}
