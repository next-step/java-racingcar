package RacingCar.model;

import NumberGenerator.NumberGenerator;

public class RacingCars {
    private RacingCar[] cars;
    private int maxPosition = 0;
    private RacingWinnerFinder finder;


    public RacingCars(String[] carNames, int moveCondition, NumberGenerator numberGenerator) {
        this.cars = new RacingCar[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            this.cars[i] = new RacingCar(moveCondition, numberGenerator, carNames[i]);
        }

        this.finder = new RacingWinnerFinder();
    }

    public void moveAll() {
        for (RacingCar car : cars) {
            car.move();
            if(car.position() > this.maxPosition){
                this.maxPosition = car.position();
            }
        }
    }

    public int[] getCarsPosition(){
        int[] positions = new int[cars.length];
        for(int i=0; i<cars.length; i++){
            positions[i] = cars[i].position();
        }

        return positions;
    }

    public String[] getWinners(){
        RacingCar[] winners = this.finder.findWinners(this.cars, maxPosition);
        String[] winnerNames = new String[winners.length];
        for (int i=0; i<winners.length; i++){
            winnerNames[i] = winners[i].name();
        }

        return winnerNames;
    }
}
