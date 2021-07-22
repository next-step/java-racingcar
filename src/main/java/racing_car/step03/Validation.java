package racing_car.step03;

public class Validation {
    public static void inputValidation(int carCount , int tryCount){
        if (carCount<=0){
            throw new IllegalArgumentException("자동차 1대 이상이어야 합니다.");
        }

        if (tryCount<=0){
            throw new IllegalArgumentException("시도 회수는 1회 이상이어야 합니다.");
        }
    }
}
