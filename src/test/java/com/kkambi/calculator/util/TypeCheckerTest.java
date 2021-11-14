package com.kkambi.calculator.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TypeCheckerTest {

    @DisplayName("숫자 형식의 문자열을 넣으면 String -> int 체크에 성공한다")
    @Test
    void checkInt() {
        assertThat(TypeChecker.isInteger("1234")).isTrue();
    }

    @DisplayName("숫자가 아닌 문자열을 넣으면 String -> int 체크에 성공한다")
    @Test
    void checkNotInt() {
        assertThat(TypeChecker.isInteger("12*4n23리뷰감사합니다")).isFalse();
    }
}