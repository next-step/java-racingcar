package study.race.model;

public class Victory {

    private RaceResult raceResult;

    public Victory(RaceResult raceResult) {
        this.raceResult = raceResult;
    }

    public void findWinner() {
        findMaxDistance();

    }

    private void findMaxDistance() {
        this.raceResult.getResult();
        //맵을 순회하면서 맥스를 찾음.


        for (int i = 0; i < this.numberOfCar; i++) {
            Car car = cars.carList().get(i);
            int distance = car.getCurrentLocation();
            compareDistance(distance);
        }
    }
    private void compareDistance(int distance) {
        if (this.maxDistance < distance) {
            this.maxDistance = distance;
        }
    }

    private void checkWinner() {
    }




}
