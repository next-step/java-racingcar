package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TermsTest {

    Terms terms;

    @BeforeEach
    void before() {
        terms = new Terms();

        terms.addTerm(1D);
        terms.addTerm(2D);
    }

    @Test
    void 생성_테스트() {
        assertNotNull(terms.getTerms());
    }

    @Test
    void addTerm() {
        assertThat(terms.getTerms().size()).isEqualTo(2);
    }

    @Test
    void nextTerm() {
        assertThat(terms.nextTerm()).isEqualTo(1D);
        assertThat(terms.nextTerm()).isEqualTo(2D);
    }
}