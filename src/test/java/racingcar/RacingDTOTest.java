package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.racing.RacingDTO;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingDTOTest {


    @Test
    @DisplayName("dto 생성자 테스트")
    public void initTest(){
        int attempts = 3;

        String test ="aim, test, tenu";
        RacingDTO racingDTO = new RacingDTO(test, attempts);
        assertThat(racingDTO.getAttempts()).isEqualTo(attempts);

    }
}
