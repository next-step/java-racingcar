package racing.vo;

public class PlayerRecord {

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
}
