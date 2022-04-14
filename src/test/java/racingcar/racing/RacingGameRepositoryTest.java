package racingcar.racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameRepositoryTest {

    RacingGameRepository racingGameRepository = new RacingGameRepository();

    @AfterEach
    void afterEach() {
        racingGameRepository.clearStore();
    }

    @Test
    void save() {
        RacingCar racingCar = new RacingCar(0, 12);
        racingGameRepository.save(racingCar);

        RacingCar result = racingGameRepository.findById(0);
        assertThat(result.getProgress()).isEqualTo(racingCar.getProgress());
        assertThat(result.getId()).isEqualTo(racingCar.getId());

    }

    @Test
    void findAll() {
        RacingCar racingCar1 = new RacingCar(0, 12);
        racingGameRepository.save(racingCar1);

        RacingCar racingCar2 = new RacingCar(1, 5);
        racingGameRepository.save(racingCar2);

        List<RacingCar> result = racingGameRepository.findAll();
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(racingCar1, racingCar2);
    }

}