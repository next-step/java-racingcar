package racingcar.racing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.generator.Generator;
import racingcar.generator.NumberGenerator;
import racingcar.play.ZeroToNineRandomPolicy;
import racingcar.racing.repository.RacingGameRepository;
import racingcar.racing.service.RacingGameService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameRepositoryTest {


    RacingGameRepository racingCarRepository = new RacingGameRepository();

    @AfterEach
    void afterEach() {
        racingCarRepository.clearStore();
    }

    @Test
    @DisplayName("RacingGameRepository save 로직 테스트")
    void save() {
        // given
        List<RacingCar> carList = new ArrayList<>(Arrays.asList( new RacingCar(0, 0),
                new RacingCar(1, 0),
                new RacingCar(1, 1),
                new RacingCar(2, 1),
                new RacingCar(1, 2)));
        int tryNumber = 0;
        int findId = 0;

        // when
        for (RacingCar racingCar : carList) {
            racingCarRepository.save(racingCar, tryNumber);
        }

        // then
        int result = (int) carList.stream()
                .filter(racingCar -> racingCar.getId() == findId).count();

        int answer = racingCarRepository.findAllById(findId).size();

        assertThat(result).isEqualTo(answer);

    }

    @DisplayName("RacingGameRepository findAllByTryNumber 테스트")
    @ParameterizedTest
    @ValueSource(ints = {3,5,4,6})
    void findAllByTryNumber(int tryNumber) {
        // given
        List<RacingCar> carList = new ArrayList<>(Arrays.asList( new RacingCar(0, 0),
                new RacingCar(1, 0),
                new RacingCar(2, 0)));


        // when
        Generator<Integer, Integer> generator = new NumberGenerator();


        for(int i = 0; i < tryNumber; i++) {
            for (RacingCar racingCar : carList) {
                int value = generator.generate(10);

                racingCar.forward(value);

                racingCarRepository.save(racingCar,  i);
            }
        }


        // then
        int result = (int) racingCarRepository.findAllByTryNumber(generator.generate(tryNumber)).size();

        assertThat(result).isEqualTo(carList.size());


    }

}