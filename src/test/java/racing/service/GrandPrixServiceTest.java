package racing.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.domain.GrandPrix;
import racing.domain.LineUp;
import racing.domain.RaceMachine;
import racing.resolver.SimpleAccelerateResolver;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class GrandPrixServiceTest {
    private final GrandPrixService grandPrixService = new GrandPrixService();
    GrandPrix grandPrix;

    @BeforeEach
    void makeTestGradPrix() {
        grandPrix = grandPrixService.createGrandPrix(new LineUp(Collections.singletonList(new RaceMachine("Lewis", new SimpleAccelerateResolver(true)))), 5);
    }

    @Test
    void testCreateGrandPrix() {
        assertThat(grandPrix).isNotNull();
        assertThat(grandPrix.getLineUp()).isNotNull();
    }

    @Test
    void testGetGrandPrixById() {
        GrandPrix result = grandPrixService.getGrandPrix(grandPrix.getId());
        assertThat(result).isEqualToComparingFieldByFieldRecursively(grandPrix);
    }
}
