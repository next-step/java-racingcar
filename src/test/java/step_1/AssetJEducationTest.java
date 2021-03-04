package step_1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("AssertJ Edu Test")
public class AssetJEducationTest {


    @DisplayName("References then, ComparingFields Then")
    @Test
    void objectAssertion() {
        Dog fido = new Dog("Fido", 5.25f);
        Dog fidosClone = new Dog("Fido", 5.25f);

        assertThat(fido)
                .isNotEqualTo(fidosClone)
                .isEqualToComparingFieldByFieldRecursively(fidosClone);
    }

    @DisplayName("Assertion Chaining, List Handle")
    @Test
    void listAssertion() {
        List<String> sampleValue = Arrays.asList("1", "2", "3");
        assertThat(sampleValue)
                .isNotEmpty()
                .startsWith("1")
                .doesNotContain("4")
                .doesNotContainNull()
                .containsSequence("2", "3");

    }

    @DisplayName("Reflect Test")
    @Test
    void reflectAssertion() {
        assertThat(Runnable.class).isInterface();
    }

    @DisplayName("Files Test")
    @Test
    void physicalFileAssertion() throws Exception {
        final File sampleFiles = File.createTempFile("aaa", "bbb");
        sampleFiles.deleteOnExit();
        assertThat(sampleFiles)
                .exists()
                .isFile()
                .canRead()
                .canWrite();
    }

    @DisplayName("Stream Compare Test")
    @Test
    void streamCompare() {
        InputStream source = new ByteArrayInputStream("foo".getBytes());
        InputStream expected = new ByteArrayInputStream("foo".getBytes());
        assertThat(source).hasSameContentAs(expected);
    }
}
