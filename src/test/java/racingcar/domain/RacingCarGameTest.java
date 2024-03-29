package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.dto.RacingResult;
import racingcar.domain.strategy.MoveStrategy;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest {

    @ParameterizedTest
    @CsvSource(value = {"5:true", "-3:false", "0:false"}, delimiter = ':')
    @DisplayName("시도횟수는 자연수여야 한다.")
    void executeRacing_시도횟수_자연수검증(int trialCnt, boolean expected) {
        Participants participants = Participants.from("pika,nana,ppo");
        RacingCarGame racingCarGame = RacingCarGame.from(participants);

        assertThat(racingCarGame.isNaturalNumber(trialCnt)).isEqualTo(expected);
    }

    @Test
    @DisplayName("입력된 자동차 이름의 개수만큼 RacingCar 객체를 생성한다")
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

    @Test
    @DisplayName("입력한 시도횟수만큼 경주가 실행된다.")
    void executeRacing_시도횟수_경주실행() {
        Participants participants = Participants.from("pika,nana,ppo");
        RacingCarGame racingCarGame = RacingCarGame.from(participants);

        int trialCnt = 5;
        RacingResult racingResult = racingCarGame.executeRacing(trialCnt);

        assertThat(racingResult.getRoundResults().size()).isEqualTo(trialCnt);
    }

}