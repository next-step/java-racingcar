package racing.basic.domain;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("자동차 게임 도메인 테스트")
class CarRacingGameTest {

    private CarRacingGame carRacingGame;

    @Mock
    private Random random;

    @BeforeEach
    void setUp() {
        carRacingGame = new CarRacingGame(random);
    }

    @Nested
    @DisplayName("다중 자동차 움직임 테스트")
    class MultipleCarDriveTest {

        @Test
        @DisplayName("전진 판단 랜덤 값이 모두 4 일 경우, 모든 배열에 +1")
        public void workCar() {
            int[] displayTrack  = {0, 0, 0};
            int[] desiredResult = {1, 1, 1};

            when(random.nextInt())
                .thenReturn(4);

            carRacingGame.nextRound(displayTrack);
            assertArrayEquals(desiredResult, displayTrack);
        }

        @Test
        @DisplayName("전진 판단 랜덤 값이 모두 3 일 경우, 배열에 변화 없음")
        public void stopCar() {
            int[] displayTrack  = {0, 0, 0};
            int[] desiredResult = {0, 0, 0};

            when(random.nextInt())
                .thenReturn(3);

            carRacingGame.nextRound(displayTrack);
            assertArrayEquals(desiredResult, displayTrack);
        }
    }

    @Nested
    @DisplayName("단일 자동차 움직임 테스트")
    class SingleCarDriveTest {

        @Test
        @DisplayName("랜덤 값 4 입력 시, 전진 값 1 리턴")
        public void workCar() {
            int result = carRacingGame.moveOrStop(4);
            assertEquals(result, 1);
        }

        @Test
        @DisplayName("랜덤 값 3 입력 시, 정지 값 0 리턴")
        public void stopCar() {
            int result = carRacingGame.moveOrStop(3);
            assertEquals(result, 0);
        }
    }
}