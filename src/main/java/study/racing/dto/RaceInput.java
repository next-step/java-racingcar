package study.racing.dto;


public class RaceInput{

    private final int numberOfCars;
    private final int numberOfAttempt;

    public RaceInput(int numberOfCars, int numberOfAttempts) {
        validate(numberOfCars, numberOfAttempts);
        this.numberOfCars = numberOfCars;
        this.numberOfAttempt = numberOfAttempts;
    }

    private void validate(int numberOfCars, int numberOfAttempts) {
        if(numberOfCars <  1){
            throw new RuntimeException("레이스 참가 차량 수는 1대 이상이어야 합니다.");
        }

        if(numberOfAttempts <  1){
            throw new RuntimeException("레이스 횟수는 1회 이상이어야 합니다.");
        }
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getNumberOfAttempt() {
        return numberOfAttempt;
    }
}
