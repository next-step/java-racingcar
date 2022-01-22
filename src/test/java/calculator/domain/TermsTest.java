package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class TermsTest {

    @Test
    void 값_리스트를_받아_생성() {
        List<Double> values = new ArrayList<>(Arrays.asList(1D, 2D));

        Terms terms = new Terms(values);

        assertThat(terms.getTerms().size()).isEqualTo(2);
    }

    @Test
    void nextTerm() {
        List<Double> values = new ArrayList<>(Arrays.asList(1D, 2D));
        Terms terms = new Terms(values);

        assertThat(terms.nextTerm()).isEqualTo(1);
        assertThat(terms.nextTerm()).isEqualTo(2);
    }

    @Test
    void hasNext_true() {
        List<Double> values = new ArrayList<>(Arrays.asList(1D, 2D));
        Terms terms = new Terms(values);

        assertTrue(terms.hasNext());
    }

    @Test
    void hasNext_false() {
        List<Double> values = new ArrayList<>(Arrays.asList(1D, 2D));
        Terms terms = new Terms(values);

        terms.nextTerm();
        terms.nextTerm();

        assertFalse(terms.hasNext());
    }
}