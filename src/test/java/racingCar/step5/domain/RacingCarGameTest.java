package racingCar.step5.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.step5.domain.dto.RacingCarGameResult;
import racingCar.step5.domain.dto.WinnerDto;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class RacingCarGameTest {
    @DisplayName("레이싱 게임 후, 매 라운드의 결과를 가지고 있다")
    @Test
    void getRaceRounds(){
        RacingCars racingCars = createRacingCarFrom("1번,2번");
        RacingCarGame game = new RacingCarGame(racingCars, new RandomNumber(4));

        //레이싱 게임으로 1번 이동
        List<RacingCars> raceResult = game.start(1);

        //레이싱 카로 직접 1번 이동
        List<RacingCars> moveResult = new ArrayList<RacingCars>();
        RacingCars moveCars = createRacingCarFrom("1번,2번");
        moveCars.move(new RandomNumber(4));
        moveResult.add(moveCars.copy());
        //레이싱 게임 결과와 레이싱 카로 직접 이동한 결과 비교
        assertThat(raceResult).isEqualTo(moveResult);
    }


    @DisplayName("레이싱 게임 후, 우승자을 알 수 있다")
    @Test
    void getWinners(){
        RacingCars racingCars = createRacingCarFrom("1번,2번");
        RacingCarGame game = new RacingCarGame(racingCars, new RandomNumber(4));

        game.start(1);
        List<RacingCar> winnerCars = game.decideWinner();

        assertThat(winnerCars).containsExactlyInAnyOrder(
                RacingCar.ofNameAndPosition("1번", 1)
                , RacingCar.ofNameAndPosition("2번", 1)
        );
    }

    private RacingCars createRacingCarFrom(String names){
        return RacingCars.ofNames(names);
    }
}