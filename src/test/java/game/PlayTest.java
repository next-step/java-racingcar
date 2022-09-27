package game;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayTest {
    private final Play play = new Play();

    @Test
    void play() {
        assertThat(play.play()).isEqualTo("실행 결과");
    }
}