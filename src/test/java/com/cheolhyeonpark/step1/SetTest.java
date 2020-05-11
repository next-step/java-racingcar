package com.cheolhyeonpark.step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("size() 메소드를 호출하면 Set의 크기가 반환된다")
    void getSizeOfSet() {
        //given

        //when
        int size = numbers.size();

        //then
        assertThat(size).isEqualTo(3);
    }
}
