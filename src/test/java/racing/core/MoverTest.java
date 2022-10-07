package racing.core;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import racing.RandomUtil;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

class MoverTest {

    private final Mover mover = new Mover();
    private static MockedStatic<RandomUtil> randomUtilMockedStatic;

    @BeforeAll
    public static void beforeAll(){
        randomUtilMockedStatic = mockStatic(RandomUtil.class);
    }

    @AfterAll
    public static void afterAll(){
        randomUtilMockedStatic.close();
    }

    @Test
    @DisplayName("4 이하의 값이 주어졌을 때 자동차를 움직이는지 확인")
    void testIfMoveWithUnder4(){
        when(RandomUtil.getRandomNumUnder10()).thenReturn(3);
        Car car = new Car();
        mover.move(car);
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("4 이상의 값이 주어졌을 때 자동차가 멈춰있는지 확인")
    void testIfMoveWithOver4(){
        when(RandomUtil.getRandomNumUnder10()).thenReturn(7);
        Car car = new Car();
        mover.move(car);
        assertThat(car.getDistance()).isEqualTo(2);
    }

}