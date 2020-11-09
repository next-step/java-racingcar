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
    void testViewReady() {
        LineUp lineUp = lineUpService.createMachines(Arrays.asList("Lewis", "Valtt"));

        RacingResultView.ready(lineUp);
        assertThat(outContent.toString())
                .contains("실행 결과");
    }

    @Test
    void testViewChampion() {
        LineUp lineUp = lineUpService.createMachines(Collections.singletonList("Lewis"));

        RacingResultView.viewChampion(lineUp);
        assertThat(outContent.toString())
                .contains("Lewis가 최종 우승");
    }

    @Test
    void testViewMultiChampion() {
        LineUp lineUp = lineUpService.createMachines(Arrays.asList("Lewis", "Valtt"));

        RacingResultView.viewChampion(lineUp);
        assertThat(outContent.toString())
                .contains("Lewis, Valtt가 최종 우승");
    }
}
