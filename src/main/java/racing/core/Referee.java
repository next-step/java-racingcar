package racing.core;

public class Referee {

    public CarList getWinners(CarList cars) {
        cars.sortDesc();
        Car firstWinner = cars.getFirstCar();
        int winnerScore = firstWinner.getDistance();
        return cars.getCarsWithSameDistance(winnerScore);
    }

}
