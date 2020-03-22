package third_racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputviewTest {

    private Inputview inputview = new Inputview();
    private int systemInValue = 0;

    @ParameterizedTest
    @ValueSource( ints = 3 )
    @DisplayName("자동차 입력값 테스트")
    void carNoInputTest(int testInput) {
        systemInValue = 3;
        System.setIn(new ByteArrayInputStream(String.valueOf(systemInValue).getBytes()));
        int carNoInput = inputview.carNoInput();
        assertThat(carNoInput).isEqualTo(testInput);
    }

    @ParameterizedTest
    @ValueSource( ints = 5 )
    @DisplayName("시도회수 입력값 테스트")
    void tryNoInputTest(int testInput) {
        systemInValue = 5;
        System.setIn(new ByteArrayInputStream(String.valueOf(systemInValue).getBytes()));
        int tryNoInput = inputview.tryNoInput();
        assertThat(tryNoInput).isEqualTo(testInput);
    }

    @ParameterizedTest
    @ValueSource( ints = {-1 , 0})
    @DisplayName("1이하 벨리데이션체크")
    void validationRangeErrorCheckTest(int testInput){
        assertThatThrownBy(()  -> {
            inputview.validationCheck(testInput);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("1 이상의 숫자를 입력하세요");
    }

    @ParameterizedTest
    @ValueSource( ints = {1, 3})
    @DisplayName("정상값 벨리데이션체크")
    void validationRangeNormalityCheckTest(int testInput){
        assertThat(inputview.validationCheck(testInput)).isEqualTo(true);
    }
}