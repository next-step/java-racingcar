package rcgame.domain;

import rcgame.dto.RcGameRequest;
import rcgame.util.NumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

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

    public RcGame(List<RcCar> rcCars) {
        this.rcCars = rcCars;
    }

    private void initRcCars(String[] AllRcCarName) {
        this.rcCars= new ArrayList<>();

        for (String rcCarName:AllRcCarName){
            this.rcCars.add(new RcCar(rcCarName));
        }
    }

    public List<RcCar> race(NumberGenerator numberGenerator) {
        currentTime ++;
        return rcCars.stream()
                .map(rcCar -> rcCar.move(numberGenerator))
                .collect(toList());
    }

    public boolean isOnGoing() {
        return totalTime > currentTime;
    }

    public List<RcCar> identifyWinner() {
        List<RcCar> winnerRcCars = new ArrayList<>();
        for (RcCar r : rcCars) {
            if (r.isSamePosition(findRcCarMaxPosition())) {
                winnerRcCars.add(r);
            }
        }
        return winnerRcCars;
    }

    private int findRcCarMaxPosition() {
        return rcCars.stream()
                .mapToInt(RcCar::getPosition)
                .max().orElse(0);
    }
}