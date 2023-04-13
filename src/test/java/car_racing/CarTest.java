package car_racing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class CarTest {
    Car carSpy = null;

    @BeforeEach
    void setUp() {
        carSpy = spy(new Car());
    }

    @AfterEach
    void tear() {
        clearAllCaches();
    }

    @Test
    @DisplayName("car의 처음 moveCount 초기값은 0이여야 한다.")
    void car_초기화() {
        // then
        assertThat(carSpy.getMoveCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("랜덤 값이 4이하일 경우 car는 움직이지 않는다.")
    void car_멈춤() {
        // given
        when(carSpy.getRandomInt()).thenReturn(3);

        // when
        carSpy.moveOrStop();

        // then
        assertThat(carSpy.getMoveCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("랜덤 값이 4초과일 경우 car는 움직인다.")
    void car_움직임() {
        //given
        when(carSpy.getRandomInt()).thenReturn(5);

        //when
        carSpy.moveOrStop();

        //then
        assertThat(carSpy.getMoveCount()).isEqualTo(1);
    }


}
