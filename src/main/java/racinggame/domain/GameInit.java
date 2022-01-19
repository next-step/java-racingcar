package racinggame.domain;

import java.util.Scanner;

public class GameInit {


    public String[] inputPlayerName(){
        Scanner scanner = new Scanner(System.in);
        String playerNames = scanner.nextLine();
        String[] playerNameList = playerNames.split(",");
        return playerNameList;
    }



}
