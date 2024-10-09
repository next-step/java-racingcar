package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RoundResultTest {

    RoundResult roundResult;

    @BeforeEach
    void createRoundResult() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Kim", 3);
        map.put("Lee", 5);
        map.put("Cha", 1);
        roundResult = new RoundResult(map);
    }

    @Test
    void getMaxPosition() {
        assertThat(roundResult.getMaxPosition()).isEqualTo(5);
    }
}