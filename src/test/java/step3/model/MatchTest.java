package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.*;

public class MatchTest {
    @DisplayName("참가차랑수, 반복횟수에 맞게 결과를 생성한다")
    @Test
    public void run() {
        //given
        int part = 5;
        int iter = 7;
        //when
        List<List<String>> display = new Match(part, iter).display();
        //then
        assertThat(display).hasSize(part);
        assertThat(display.get(0)).hasSize(iter);
    }

}