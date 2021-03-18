package step4.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.ipnut.InputNames;
import step4.domain.ipnut.InputRound;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class RequestDtoTest {

    private final int ROUND_COUNT = 5;
    private InputNames inputNames;
    private InputRound inputRound;

    @BeforeEach
    void setUp() {
        List<String> names = Arrays.stream("a,b,c".split(",")).collect(Collectors.toList());
        inputNames = new InputNames(names);
        inputRound = new InputRound(ROUND_COUNT);
    }

    @DisplayName("RequestDto 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // when
        RequestDto requestDto = new RequestDto(inputNames, inputRound);

        // then
        assertThat(requestDto).isNotNull();
    }
}