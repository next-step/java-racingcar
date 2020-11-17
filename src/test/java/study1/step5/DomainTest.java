package study1.step5;

import org.junit.jupiter.api.Test;

public class DomainTest {

    @Test
    void raceTest(){
        Decision moveDecision = new MoveDecision();
        int roundCnt = 10;
        String racerList = "first,second,third";

        Race race = new Race();

        race.race(roundCnt, racerList, moveDecision);
    }

    @Test
    void everyoneIsWinnerTest(){
        Decision moveDecision = new FixedMoveDecision(10);
        int roundCnt = 10;
        String racerList = "first,second,third";

        Race race = new Race();

        race.race(roundCnt, racerList, moveDecision);
    }
}
