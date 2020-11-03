package racing.service;

import org.junit.jupiter.api.Test;
import racing.domain.GrandPrix;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingServiceTest {
    RacingService racingService = new RacingService();
    @Test
    void testCreateGrandPrix(){
        GrandPrix grandPrix = racingService.createGrandPrix(3,5);
        assertThat(grandPrix.getId()).isNotNull();
    }

    @Test
    void testGetGrandPrixById(){
        GrandPrix grandPrix = racingService.createGrandPrix(3,5);
        GrandPrix result = racingService.getGrandPrix(grandPrix.getId());

        assertThat(result).isEqualToComparingFieldByFieldRecursively(grandPrix);
    }
}
