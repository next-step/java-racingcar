package ugemang.nextstep.domain.curcuit;

import ugemang.nextstep.domain.car.Car;
import ugemang.nextstep.domain.car.Cars;
import ugemang.nextstep.domain.car.Winner;
import ugemang.nextstep.domain.message.RacingGameMessageEnum;
import ugemang.nextstep.domain.status.RacingGameStatusEnum;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Curcuit {
    private final Round round;
    private final Cars players;

    public Curcuit(Round round, Cars players) {
        this.round = round;
        this.players = players;
    }

    public Round getRound() {
        return round;
    }

    public Cars getPlayers() {
        return players;
    }

    public void lap(int count) {
        if(isOverRound(count)) {
            throw new IllegalArgumentException(RacingGameMessageEnum.E5.getMessage());
        }

        for(Car i : getPlayers().getCars()){
            i.changeGears(getSpeed());
        }
    }

    private Integer getSpeed(){
        return (int)(Math.random() * (RacingGameStatusEnum.MAX_SPEED.getVal()));
    }

    public Winner getWinner(){
        List<Car> carsSortByDistance = new ArrayList<>(getPlayers().getCars());
        carsSortByDistance.sort(Comparator.comparingInt(i->i.getTotalDistance()));
        Integer distanceTopRank = carsSortByDistance.get(carsSortByDistance.size()-1)
                                                    .getTotalDistance();
        carsSortByDistance.removeIf(car -> car.getTotalDistance() < distanceTopRank);
        Winner winners = new Winner(carsSortByDistance);
        return winners;
    }

    public boolean isOverRound(int count){
        if(getRound().getRound() < count){
            return true;
        }
        return false;
    }
}
