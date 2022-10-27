package step3;

public class Racing {
    public static void main(String[] args) {

        /* 사용자의 입력을 받는 것으로 변경 예정 */
        int numOfCars = 3;
        int countTrial = 5;

        for (int i = 0; i < countTrial; i++) {
            for (int j = 0; j < numOfCars; j++) {
                RacingCar racingCar = new RacingCar();
                if (racingCar.goingAheadOrNot(new RandomBounded())) {
                    racingCar = racingCar.goAhead();
                }
            }
        }

    }
}
