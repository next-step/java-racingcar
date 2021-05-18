package racing;

import org.junit.jupiter.api.Test;
import racing.racing.RacingCar;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingCarTest {

    @Test
    public void Test(){
        String name= "강호동가스가스,유재석";
        RacingCar ra = new RacingCar();
        String spName = null;

        assertEquals(ra.splitName(name)[0], "강호동");
    }

    @Test
    public void Test2(){
        RacingCar ra = new RacingCar();
        System.out.println("sdfsfsff : "+ra.randomNumber());
    }
    @Test
    public void winnerTest(){
        String[] winner = new String[3];
        winner[0] = "유재석 : ---";
        winner[1] = "강호동 : --";
        winner[2] = "신동엽 : ----";
        RacingCar ra = new RacingCar();

        ra.winner(winner);

    }


}