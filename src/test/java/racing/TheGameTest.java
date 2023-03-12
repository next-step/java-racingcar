package racing;

import org.junit.jupiter.api.BeforeEach;


public class TheGameTest {

    TheGame thegame;


    @BeforeEach
    public void init() {
        thegame = new TheGame("Kai", 5);
    }
}