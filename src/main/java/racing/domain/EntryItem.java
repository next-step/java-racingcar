package racing.domain;

import racing.vo.PlayerRecord;

public class EntryItem{

    private RacingCar car;

    private String playerName;

    public EntryItem(String playerName, RacingCar car){
        this.playerName = playerName;
        this.car = car;
    }

    public PlayerRecord drive(){
        return new PlayerRecord(playerName, car.move());
    }

}
