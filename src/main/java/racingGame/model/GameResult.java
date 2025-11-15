package racingGame.model;


import java.util.ArrayList;
import java.util.List;

public record GameResult(List<ProgressRecord> progressRecords) {
    
    public GameResult(List<ProgressRecord> progressRecords) {
        this.progressRecords = new ArrayList<>(progressRecords);
    }
    
    public List<Car> findWinners() {
        return findMaxCar(findMaxLocation());
    }
    
    private int findMaxLocation() {
        int max = Integer.MIN_VALUE;
        for(Car joinCar: progressRecords.getLast().joinCars()) {
            max = Math.max(max, joinCar.findLocation());
        }
        return max;
    }
    
    private List<Car> findMaxCar(int max) {
        List<Car> winnerCars = new ArrayList<>();
        for(Car joinCar: progressRecords.getLast().joinCars()) {
            if(max == joinCar.findLocation()) {
                winnerCars.add(joinCar);
            }
        }
        return winnerCars;
    }

}
