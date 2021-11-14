package racing.basic.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import racing.basic.resolver.InputViewResolver;

@ExtendWith(MockitoExtension.class)
@DisplayName("자동차 경주 게임")
class CarRacingApplicationTest {

    private CarRacingApplication racingGame;

    @Mock
    private InputViewResolver inputViewResolver;

    @BeforeEach
    void before() {
        racingGame = new CarRacingApplication(inputViewResolver);
    }

    @Test
    @DisplayName("게임 시작 테스트")
    public void start() {
        Mockito.when(inputViewResolver.takeInput())
                        .thenReturn(3, 5);
        racingGame.startGame();
    }
}