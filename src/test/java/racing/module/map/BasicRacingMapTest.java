package racing.module.map;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.Car;

class BasicRacingMapTest {

    private RacingMap racingMap;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp(){
        racingMap = new BasicRacingMap(List.of(new Car(1), new Car(2), new Car(3)));
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void showCars(){
        racingMap.showCars();
        assertEquals("-\n--\n---\n\n",outputStreamCaptor.toString());
    }


}