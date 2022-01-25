package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import org.assertj.core.util.Strings;

abstract public class RandomConfigTest {

    private PrintStream standardOut;
    private OutputStream captor;

    protected void setUp() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    protected void running(final String... args) {
        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(
            () -> subject(args)
        );
    }

    protected void verify(final String... args) {
        assertThat(output()).contains(args);
    }

    private void subject(final String... args) {
        command(args);
        runMain();
    }

    protected String output() {
        return captor.toString().trim();
    }

    protected void outputStandard() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    public abstract void runMain();

    private void command(final String... args) {
        final byte[] buf = Strings.join(args).with("\n").getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}
