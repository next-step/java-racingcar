package rcgame.domain;

import rcgame.dto.RcGameRequest;
import rcgame.util.NumberGenerator;

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

    private void initRcCars(String[] allRcCarName) {
        this.rcCars= new ArrayList<>();

        for (String rcCarName:allRcCarName){
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

    public static List<RcCar> identifyWinner(List<RcCar> rcCars) {
        List<RcCar> winnerRcCars = new ArrayList<>();
        for (RcCar r : rcCars) {
            if (r.isSamePosition(findRcCarMaxPosition(rcCars))) {
                winnerRcCars.add(r);
            }
        }
        return winnerRcCars;
    }

    private static int findRcCarMaxPosition(List<RcCar> rcCars) {
        return rcCars.stream()
                .mapToInt(RcCar::getPosition)
                .max().orElse(0);
    }

    public List<RcCar> getRcCars() {
        return rcCars;
    }
}