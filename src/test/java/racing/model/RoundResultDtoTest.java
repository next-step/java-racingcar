package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class RoundResultDtoTest {

    @DisplayName("CarVO 리스트로 RoundResultDto 생성 성공 테스트")
    @Test
    void createRoundResultDtoTest() {
        assertDoesNotThrow(() -> new RoundResultDto(Arrays.asList(new CarVO("test1", 1))));
    }
}
