package domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InputTest {
    private Input input;

    @Before
    public void setUp() {
        input = mock(Input.class);
        when(input.nextInt()).thenReturn(3);
    }

    @Test
    public void next_int() {
        assertThat(input.nextInt()).isEqualTo(3);
    }
}
