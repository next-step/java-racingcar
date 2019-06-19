package racing.vo;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StageOptionTest {


    @ParameterizedTest
    @MethodSource("createEntryInformation")
    void parseStringToEntry(String entryInformation, int entrySize){
        // Arrange & Action
        StageOption option = new StageOption(entryInformation);

        // Assertion
        assertThat(option.getEntrySize()).isEqualTo(entrySize);
    }

    private static Stream<Arguments> createEntryInformation(){
        return Stream.of(
                Arguments.of("A,B", 2),
                Arguments.of("Kevin Lee, Stark", 2),   // 공백이 포함된 이름
                Arguments.of("대한, 민국, 만세,", 3));    // 한국어, 구분자로 종료되는 경우
    }
}