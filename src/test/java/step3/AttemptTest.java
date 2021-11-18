package step3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;

class AttemptTest {
    Attempt attempt = new Attempt(5);

    @Test
    void testIsEnd() {
        Attempt attempt = new Attempt(1);
        attempt.make();
        boolean isEnd = attempt.isEnd();
        assertThat(isEnd).isTrue();
    }

}