package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingDTOTest {


    @Test
    @DisplayName("dto 생성자 테스트")
    public void initTest(){
        int attempts = 3;

        String test ="aim, test, tenu";
        RacingDTO racingDTO = new RacingDTO(test, attempts);

        String[] testArr = {"aim", "test","nony"};
        RacingDTO racingDTO1 = new RacingDTO(testArr,attempts);

        List<String> testList = new ArrayList<>();
        testList.add("aim");
        testList.add("tatoo");
        RacingDTO racingDTO2 = new RacingDTO(testList, attempts);

        assertThat(racingDTO.getAttempts()).isEqualTo(attempts);
        assertThat(racingDTO1.getAttempts()).isEqualTo(attempts);
        assertThat(racingDTO2.getAttempts()).isEqualTo(attempts);

    }
}
