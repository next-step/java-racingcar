package rcgame.domain;

import rcgame.dto.RcGameRequest;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class RcGame {
    private List<RcCar> rcCars;
    private int totalTime;
    private int currentTime;

    public RcGame(RcGameRequest request) {
        this.initRcCars(request.getRcCarName());
        this.totalTime = request.getTime();
        this.currentTime = 0;
    }

    private void initRcCars(String[] AllRcCarName) {
        this.rcCars= new ArrayList<>();

        for (String rcCarName:AllRcCarName){
            this.rcCars.add(new RcCar(rcCarName));
        }
    }

    public List<RcCar> race() {
        currentTime ++;

        return rcCars.stream()
                .map(RcCar::move)
                .collect(toList());
    }

    public boolean isOnGoing() {
        return totalTime > currentTime;
    }


    public List<RcCar> identifyWinner() {

        int maxPosition = getMaxPosition();

        List<RcCar> list = new ArrayList<>();
        for (RcCar r : rcCars) {
            if (r.isSamePosition(maxPosition)) {
                list.add(r);
            }
        }
        return list;

    }

    private int getMaxPosition() {
        return rcCars.stream()
                .mapToInt(RcCar::getPosition)
                .max().orElse(0);
    }
}