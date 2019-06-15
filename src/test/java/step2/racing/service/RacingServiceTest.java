package step2.racing.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingServiceTest {

    private RacingService racingService;

    @BeforeEach
    void setUp() {

        racingService = new RacingService(3, 5);
    }

    @Test
    void start() {

        racingService.run();
    }
}