package racing.vo;

import racing.domain.RacingCar;

public class EntryItem implements Comparable<EntryItem>{

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

    @Override
    public int compareTo(EntryItem other) {
        if(other == null){
            return 1;
        }

        if(this.car.getMileage() == other.car.getMileage()){
            return 0;
        }

        return (this.car.getMileage() > other.car.getMileage()) ? 1 : -1;
    }

}
