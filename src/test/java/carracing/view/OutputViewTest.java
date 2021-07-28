package carracing.view;

import carracing.domain.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    private ByteArrayOutputStream output;
    private OutputView outputView;

    @BeforeEach
    void setUp() {
        output = new ByteArrayOutputStream();
        outputView = OutputView.of(new PrintStream(output));
    }

    @ParameterizedTest(name = "위치 만큼 '-'가 출력된다.")
    @ValueSource(ints = {1, 10, 100})
    public void positionPrintTest(int position) {
        outputView.printPosition(PositionRenderer.of(Position.of(position)));
        String expected = String.join("", Collections.nCopies(position, "-"));
        assertThat(output.toString().trim()).isEqualTo(expected);
    }

}