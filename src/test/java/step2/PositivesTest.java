package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author : 0giri
 * @since : 2023/04/12
 */
public class PositivesTest {

    private List<Integer> integers;

    @BeforeEach
    void setUp() {
        integers = List.of(1, 2, 3);
    }

    @Test
    void 양수만_가진_리스트로_생성() {
        Positives positives = new Positives(integers);
        assertThat(positives.values()).hasSize(3);
    }

    @Test
    void 음수_포함한_리스트로_생성시_예외() {
        assertThatThrownBy(() -> {
            integers = List.of(-1, 2, 3);
            new Positives(integers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Positive_값_총합() {
        Positives positives = new Positives(integers);
        assertThat(positives.sum()).isEqualTo(6);
    }
}
