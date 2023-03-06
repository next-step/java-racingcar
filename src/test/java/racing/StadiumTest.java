package racing;

import org.junit.jupiter.api.BeforeEach;


public class StadiumTest {

    Stadium stadium;



    @BeforeEach
    public void init() {
        stadium = new Stadium("lina", 5);
    }
}