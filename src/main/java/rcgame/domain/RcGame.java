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

    private void initRcCars(String[] rcCarName) {
        this.rcCars= new ArrayList<>();

        for(int i = 0; i < rcCarName.length; i++) {
            this.rcCars.add(new RcCar(rcCarName[i]));
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

        return rcCars.stream()
                .filter(r -> r.getPosition() == maxPosition)
                .collect(toList());

    }

    private int getMaxPosition() {
        return rcCars.stream()
                .mapToInt(RcCar::getPosition)
                .max().orElse(0);
    }
}