package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.domain.CarStatement;

import static org.assertj.core.api.Assertions.assertThat;

public class CarStatementTest {
    private static final String INPUT_SAMPLE_NAME = "car";

    private CarStatement carStatement;

    @BeforeEach
    void setUp() {
        carStatement = new CarStatement(INPUT_SAMPLE_NAME);
    }

    @Test
    void max() {
        assertThat(carStatement.max(1)).isEqualTo(1);
    }
}
