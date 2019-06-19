package racing.vo;

import racing.domain.RacingCar;

public class EntrySlot {

    RacingCar car;

    String playerName;

    public EntrySlot(String playerName, RacingCar car){
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
