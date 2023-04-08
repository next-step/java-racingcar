package carracing.race.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class ResultViewTest {
    private ResultView resultView;
    @BeforeEach
    public void beforeEach() {
        this.resultView = new ResultView(new PrintStream(new PrintStream(new ByteArrayOutputStream())));

    }

    @DisplayName("")
    @Test
    public void iteration() {
        //given
        int
        //when
        resultview
        //then
    }

}