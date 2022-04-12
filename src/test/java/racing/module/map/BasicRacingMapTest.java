package racing.module.map;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BasicRacingMapTest {

    private RacingMap racingMap;

    @BeforeEach
    void setUp(){
        racingMap = new BasicRacingMap();
    }

    @Test
    void drawCar(){
        racingMap.drawCar(3);
        assertThat(racingMap.getMap().get(0)).isEqualTo("---");
    }


}