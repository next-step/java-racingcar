package racing.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.utils.MovableValueMovingStrategy;
import racing.utils.MovingStrategy;

class RacingTest {

    private List<String> names = new ArrayList<>();

    private static final String winner = "winner";
    private static final String loser = "loser";

    @BeforeEach
    public void setUp() {
        names.add(winner);
        names.add(loser);
    }

    @Test
    @DisplayName("여러개의 자동차 이름으로 올바르게 레이싱을 생성한다.")
    void create_racing() {
        //given

        //when
        Racing racing = new Racing(names);
        Car appleCar = racing.getCars().get(0);
        Car peachCar = racing.getCars().get(1);

        //then
        assertEquals(racing.getCars().size(), 2);
        assertEquals(appleCar.getName(), winner);
        assertEquals(appleCar.getDistance(), 0);
        assertEquals(peachCar.getName(), loser);
        assertEquals(peachCar.getDistance(), 0);
    }

    @Test
    @DisplayName("이동거리가 가장 많은 자동차를 우승자로 나타낸다.")
    void show_one_winner() {
        //given
        Racing racing = new Racing(names);
        MovingStrategy movingStrategy = new MovableValueMovingStrategy();
        racing.getCars().get(0).move(movingStrategy);

        //when
        List<String> winners = racing.winners();

        //then
        assertTrue(winners.contains(winner));
    }

    @Test
    @DisplayName("이동거리가 가장 많은 자동차가 여러대일 경우 여러명의 우승자를 나타낸다.")
    void show_multiple_winners() {
        //given
        Racing racing = new Racing(names);
        MovingStrategy movingStrategy = new MovableValueMovingStrategy();
        racing.getCars().get(0).move(movingStrategy);
        racing.getCars().get(1).move(movingStrategy);

        //when
        List<String> winners = racing.winners();

        //then
        assertEquals(winners.size(), 2);
        assertTrue(winners.contains(winner));
        assertTrue(winners.contains(loser));
    }
}