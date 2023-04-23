package RacingCar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;

public class InputManagerTest {
    public InputManager inputManager = new InputManager();
    private final InputStream systemIn = System.in;

    @AfterEach
    public void restoreSystemInput() {
        System.setIn(systemIn);
    }

    @Test
    void 사용자_입력_받기() {
        System.setIn(new ByteArrayInputStream("3".getBytes()));
        assertThat(inputManager.getUserInput()).isEqualTo(3);
    }
}
