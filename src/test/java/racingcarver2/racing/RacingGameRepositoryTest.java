package racingcarver2.racing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import racingcar.racing.RacingGameRepository;

import static org.junit.jupiter.api.Assertions.*;

class RacingGameRepositoryTest {

    RacingGameRepository racingGameRepository = new RacingGameRepository();

    @AfterEach
    void afterEach() {
        racingGameRepository.clearStore();
    }

    @Test
    void save() {

    }

    @Test
    void findAll() {

    }

    @Test
    void clearStore() {

    }
}