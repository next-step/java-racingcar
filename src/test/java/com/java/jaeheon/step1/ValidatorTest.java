package com.java.jaeheon.step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ValidatorTest {

    Validator validator;

    @BeforeEach
    void setUp() {
        this.validator = new Validator();
    }

    @Test
    void isNotBlank() {
        assertThat(validator.isNotBlank("5*3")).isTrue();
        assertThatIllegalArgumentException().isThrownBy(() -> validator.isNotBlank(null));
        assertThatIllegalArgumentException().isThrownBy(() -> validator.isNotBlank(""));
    }

    @Test
    void validateSize(){
        assertThatIllegalArgumentException().isThrownBy(() -> validator.validateSize(1));
        assertThatIllegalArgumentException().isThrownBy(() -> validator.validateSize(4));
    }

    @Test
    void isOdd(){
        assertThat(validator.isOdd(2)).isFalse();
        assertThat(validator.isOdd(3)).isTrue();
    }

    @Test
    void isNumber(){
        assertThat(validator.isNumber("3")).isTrue();
        assertThatIllegalArgumentException().isThrownBy(() -> validator.isNumber("three"));
    }

}
