package racingcar;

import java.util.Scanner;

public class Admin {

    Game game = new Game();
    public void InputCarCount(){
        game.setCars(Integer.parseInt(new Scanner(System.in).nextLine()));
    }

    public void InputRoundCount(){
        game.setRoundCount(Integer.parseInt(new Scanner(System.in).nextLine()));
    }
}
