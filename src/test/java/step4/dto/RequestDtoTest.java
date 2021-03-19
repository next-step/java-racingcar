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
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

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

    @DisplayName("RequestDto 인스턴스 부적절한 값 주입시 예외 발생 여부 테스트")
    @Test
    void 검증() {
        // given
        InputNames inputNames = null;
        InputRound inputRound = null;

        // when and then
        assertThatThrownBy(() -> {
            new RequestDto(inputNames, inputRound);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 값을 사용했습니다.");
    }

    @DisplayName("RequestDto 인스턴스가 포함한 값 반환 여부 테스트")
    @Test
    void 반환() {
        // given
        RequestDto requestDto = new RequestDto(inputNames, inputRound);

        // when
        InputNames inputNamesActual = requestDto.inputNames();
        InputRound inputRoundActual = requestDto.inputRound();

        assertAll(
                () -> assertThat(inputNamesActual).isEqualTo(inputNames),
                () -> assertThat(inputRoundActual).isEqualTo(inputRound)
        );

    }

}