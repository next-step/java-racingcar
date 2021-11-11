package edu.nextstep.camp;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {
    private static final Collection<Name> TEST_WINNER = Stream.of("test0", "test1")
            .map(Name::of)
            .collect(Collectors.toList());

    @Test
    public void create() {
        assertThat(Winners.of(TEST_WINNER).stream()).hasSameElementsAs(TEST_WINNER);
        assertThat(Winners.of(TEST_WINNER.stream()).stream()).hasSameElementsAs(TEST_WINNER);
    }
}
