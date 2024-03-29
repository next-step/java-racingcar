package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.strategy.MoveStrategy;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest {
    @Test
    @DisplayName("입력된 자동차 대수만큼 RacingCar 객체를 생성한다")
    void createCarList_자동차대수() {
        String participantsNames = "a, b, c, d";
        Participants participants = Participants.from(participantsNames);
        Map<Participant, Car> carList = RacingCarGame.createRacingCars(participants);
        int actual = participantsNames.split(",").length;
        int expected = carList.keySet().size();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("전략에 따라 랜덤값이 0이상 3이하인 경우 자동차는 정지한다")
    void playRoundsAndReturnCarList_정지() {
        Car car = new Car();
        int beforePostion = car.getPosition();
        MoveStrategy noMoveStrategy = () -> false;

        car.moveForward(noMoveStrategy);

        int afterPosition = car.getPosition();
        assertThat(beforePostion).isEqualTo(afterPosition);
    }

    @Test
    @DisplayName("전략에 따라 랜덤값이 4이상 9이하 경우 자동차는 전진한다")
    void playRoundsAndReturnCarList_전진() {
        Car car = new Car();
        int beforePostion = car.getPosition();
        MoveStrategy noMoveStrategy = () -> true;

        car.moveForward(noMoveStrategy);

        int afterPosition = car.getPosition();
        assertThat(beforePostion + 1).isEqualTo(afterPosition);
    }
}