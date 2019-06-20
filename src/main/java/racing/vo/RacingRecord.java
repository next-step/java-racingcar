package racing.vo;

public class RacingRecord{

    private int position;

    private String playerName;

    public RacingRecord(String playerName, int position){
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
