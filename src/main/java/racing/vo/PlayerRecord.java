package racing.vo;

import java.util.Comparator;

public class PlayerRecord implements Comparable<PlayerRecord>{

    private int position;

    private String playerName;

    public PlayerRecord(String playerName, int position){
        this.playerName = playerName;
        this.position = position;
    }

    public int getPosition(){
        return position;
    }

    public String getPlayerName(){
        return playerName;
    }

    @Override
    public int compareTo(PlayerRecord other) {
        if(other == null){
            return 1;
        }

        if(this.position == other.position){
            return 0;
        }

        return (this.position > other.position) ? 1 : -1;

    }
}
