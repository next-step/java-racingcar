package racing.service;

import org.junit.jupiter.api.Test;
import racing.domain.GrandPrix;
import racing.domain.LineUp;
import racing.domain.RaceMachine;
import racing.resolver.SimpleAccelerateResolver;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class GrandPrixServiceTest {
    private final GrandPrixService grandPrixService = new GrandPrixService();

    @Test
    void testCreateGrandPrix() {
        GrandPrix grandPrix = grandPrixService.createGrandPrix(new LineUp(Collections.singletonList(new RaceMachine("Lewis Hamilton", new SimpleAccelerateResolver(true)))), 5);
        assertThat(grandPrix).isNotNull();
        assertThat(grandPrix.getLineUp()).isNotNull();
    }

    @Test
    void testGetGrandPrixById() {
        GrandPrix grandPrix = grandPrixService.createGrandPrix(new LineUp(Collections.singletonList(new RaceMachine("Lewis Hamilton", new SimpleAccelerateResolver(true)))), 5);
        GrandPrix result = grandPrixService.getGrandPrix(grandPrix.getId());

        assertThat(result).isEqualToComparingFieldByFieldRecursively(grandPrix);
    }
}
