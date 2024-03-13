package racing_winner;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class InputLayerTest {

    private InputConsole inputConsole;
    private InputLayer inputLayer;


    @BeforeEach
    void setUp() {
        inputConsole = mock(InputConsole.class);
        inputLayer = new InputLayer(inputConsole);
    }

    @Nested
    class carName {
        @Test
        @DisplayName(",를 포함하는 문자열기준으로 리스트로 분리를한다.")
        void getCarNamesSuccess() {

            when(inputConsole.readCarNames()).thenReturn("kong,siri");

            assertThat(inputLayer.getCarNames().size()).isEqualTo(2);
        }

        @Test
        @DisplayName(",를 기준으로 문자열의 길이가 5이상일경우 exception이 발생한다.")
        void exceedLengthThrowException() {
            when(inputConsole.readCarNames()).thenReturn("seungsu,jy");

            assertThatThrownBy(() -> inputLayer.getCarNames()).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class racingCount {
        @Test
        @DisplayName("문자열값 입력값이 정수로 반환된다.")
        void readGameCountSuccess() {

            when(inputConsole.readGameCount()).thenReturn("3");

            assertThat(inputLayer.getGameCount()).isEqualTo(3);
        }

        @Test
        @DisplayName("입력값이 정수가 아닐경우 Exception이 발생한다.")
        void exceedLengthThrowException() {
            when(inputConsole.readGameCount()).thenReturn("2s");

            assertThatThrownBy(() -> inputLayer.getGameCount()).isInstanceOf(NumberFormatException.class);
        }
    }

}
