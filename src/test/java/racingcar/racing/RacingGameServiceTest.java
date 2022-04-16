package racingcar.racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.generator.Generator;
import racingcar.generator.NumberGenerator;
import racingcar.play.ZeroToNineRandomPolicy;
import racingcar.racing.repository.RacingGameRepository;
import racingcar.racing.service.RacingGameService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameServiceTest {

    RacingGameService racingGameService = new RacingGameService(new ZeroToNineRandomPolicy(new NumberGenerator()));


    RacingGameRepository racingCarRepository = new RacingGameRepository();

    @BeforeEach
    void afterEach() {
        racingCarRepository.clearStore();
    }

    @DisplayName("RacingGameService playGame & findAllByTryNumber 테스트")
    @ParameterizedTest
    @ValueSource(ints = {3,5,4,6})
    void findAllByTryNumber(int tryNumber) {
        // given
        List<RacingCar> carList = new ArrayList<>(Arrays.asList( new RacingCar(0, 0),
                new RacingCar(1, 0),
                new RacingCar(2, 0)));


        // when
        Generator<Integer, Integer> generator = new NumberGenerator();



        for (RacingCar racingCar : carList) {
           racingGameService.playGame(racingCar, tryNumber);
        }



        // then
        int result = (int) racingGameService.findAllByTryNumber(generator.generate(tryNumber)).size();

        assertThat(result).isEqualTo(carList.size());


    }


}