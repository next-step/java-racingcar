package racing.vo;

import racing.domain.RacingCar;

public class EntryItem {

    RacingCar car;

    String playerName;

    public EntryItem(String playerName, RacingCar car){
        this.playerName = playerName;
        this.car = car;
    }

    public int drive(){
        return car.move();
    }

    public int getCarMilieage(){
        return car.getMileage();
    }

    public String getPlayerName(){
        return playerName;
    }
}
