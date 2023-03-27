package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TheGameTest {
    TheGame thegame;

    @Test
    @BeforeEach
    public void init() {
        thegame = new TheGame("Kai", 5);
    }
}