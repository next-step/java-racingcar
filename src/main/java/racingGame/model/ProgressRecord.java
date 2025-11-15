package racingGame.model;

public record ProgressRecord(JoinCars joinCars) {
    
    // ? 깊은 복사가 필요하게된 원인을 사전에 포착하기 위한 테스트 방법은?
    public ProgressRecord(JoinCars joinCars) {
        JoinCars cars = new JoinCars();
        for(Car joinCar: joinCars.cars()) {
            cars.addJoinCars(new Car(joinCar));
        }
        this.joinCars = cars;
    }
}
