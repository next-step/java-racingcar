package game;

import java.util.ArrayList;
import java.util.List;

public class GamePlay {

    public List<Player> createPlayer(String playerList) {
        String[] playerArray = playerList.split(",");
        System.out.println(playerArray.length);
        if(playerList.trim().isEmpty()){
            throw new IllegalArgumentException("자동차는 최소 1대 이상이어야 한다.");
        }
        List<Player> list = new ArrayList<>();
        for (String playerName : playerArray) {
            if(playerName.length() > 4){
                throw new IllegalArgumentException("자동차 이름은 5글자를 초과할수 없습니다.");
            }
            Player player = new Player(playerName);
            list.add(player);
        }
        return list;
    }
}
