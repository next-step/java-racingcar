package race;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class JudgeCarMovementTest {
    @Mock
    private Random random;

    @InjectMocks
    private JudgeCarMovement dut;

    @AfterEach
    void tearDown() {
        verifyNoMoreInteractions(random);
    }

    @Test
    void stay() {
        when(random.nextInt(10)).thenReturn(3);

        assertThat(dut.judge()).isEqualTo(JudgeCarMovement.Judge.STAY);
    }

    @Test
    void move() {
        when(random.nextInt(10)).thenReturn(4);

        assertThat(dut.judge()).isEqualTo(JudgeCarMovement.Judge.MOVE);
    }
}
