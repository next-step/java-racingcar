package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomCommanderTest {

    @DisplayName("랜덤 명령을 생성하는 테스트")
    @Test
    public void randomCommandCreateTest() {
        RandomCommander commander = new RandomCommander();
        String commandResult = commander.generateCommand();

        assertThat(commandResult).isNotNull();;
    }



}
