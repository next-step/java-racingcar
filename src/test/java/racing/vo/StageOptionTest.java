package racing.vo;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StageOptionTest {

    private static final String SEPARATOR = ",";

    @DisplayName("선수명단 문자열 처리")
    @ParameterizedTest
    @MethodSource("createEntryInformation")
    void parseStringToEntry(String entryInformation, int entrySize){

        // Arrange & Action
        int roundLimit = 5;
        StageOption option = new StageOption(entryInformation, SEPARATOR, roundLimit);

        // Assertion
        assertThat(option.getEntrySize()).isEqualTo(entrySize);
        assertThat(option.getRoundLimit()).isEqualTo(roundLimit);
    }

    private static Stream<Arguments> createEntryInformation(){
        return Stream.of(
                Arguments.of("A,B", 2),
                Arguments.of("Kevin Lee, Stark", 2),   // 공백이 포함된 이름
                Arguments.of("대한, 민국, 만세,", 3));    // 한국어, 구분자로 종료되는 경우
    }

    @DisplayName("선수명단 순서, 이름 확인")
    @Test
    void getPlayerList(){

        // Arrange, Action
        StageOption option = new StageOption("A,B", SEPARATOR, 1);

        // Assertion
        assertThat(option.getPlayerName(0)).isEqualTo("A");
    }
}