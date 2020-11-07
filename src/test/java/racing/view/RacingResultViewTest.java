package racing.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.domain.LineUp;
import racing.resolver.SimpleAccelerateResolver;
import racing.service.LineUpService;
import racing.service.RaceMachineService;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class RacingResultViewTest {
    private final LineUpService lineUpService = new LineUpService(new RaceMachineService(), new SimpleAccelerateResolver(true));
    private ByteArrayOutputStream outContent;

    @BeforeEach
    private void getOutStream() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    private void closeOutStream() throws IOException {
        outContent.close();
    }

    @Test
    void testtViewReady() {
        LineUp lineUp = lineUpService.createMachines(Arrays.asList("Lewis Hamilton", "Valtteri Bottas"));

        RacingResultView.ready(lineUp);
        assertThat(outContent.toString())
                .contains("Lewis Hamilton : -")
                .contains("Valtteri Bottas : -");
    }

    @Test
    void testViewChampion() {
        LineUp lineUp = lineUpService.createMachines(Collections.singletonList("Lewis Hamilton"));

        RacingResultView.champion(lineUp);
        assertThat(outContent.toString())
                .contains("Lewis Hamilton가 최종 우승");
    }

    @Test
    void testViewMultiChampion() {
        LineUp lineUp = lineUpService.createMachines(Arrays.asList("Lewis Hamilton", "Valtteri Bottas"));

        RacingResultView.champion(lineUp);
        assertThat(outContent.toString())
                .contains("Lewis Hamilton, Valtteri Bottas가 최종 우승");
    }
}
