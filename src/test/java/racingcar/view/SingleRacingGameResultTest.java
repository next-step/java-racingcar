//package racingcar.view;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.util.Arrays;
//import java.util.List;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import racingcar.domain.RacingCar;
//
//public class SingleRacingGameResultTest {
//
//    @Test
//    @DisplayName("자동차 게임 실행 결과를 알려준다.")
//    void game_result() {
//        // given
//        SingleRacingGameResult gameResult = new SingleRacingGameResult(racingCars);
//        List<RacingCar> racingCars = createRacingCars();
//
//        // when
//        String result = gameResult.create(racingCars);
//
//        // then
//        assertThat(result).isEqualTo(
//                "tobi : -\n"
//                        + "pobi : --\n"
//                        + "k3 : ---\n"
//                        + "\n");
//    }
//
//    private List<RacingCar> createRacingCars() {
//        return Arrays.asList(
//                new RacingCar("tobi", 1),
//                new RacingCar("pobi", 2),
//                new RacingCar("k3", 3)
//        );
//    }
//}
