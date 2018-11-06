package rcgame.domain;

import rcgame.dto.RcGameRequestDto;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class RcGame {
    private List<RcCar> rcCars;
    private int totalTime;
    private int currentTime;

    public RcGame(RcGameRequestDto request) {
        this.initRcCars(request.getCarNumber());
        this.totalTime = request.getTime();
        this.currentTime = 0;
    }

    private void initRcCars(int rcCarNumber) {
        this.rcCars= new ArrayList<>();
        for(int i = 0; i < rcCarNumber; i++) {
            this.rcCars.add(new RcCar());
        }
    }

    public List<Integer> race() {
        currentTime ++;
        return rcCars.stream()
                .map(RcCar::move)
                .collect(toList());
    }

    public boolean isOnGoing() {
        return totalTime > currentTime;
    }
}