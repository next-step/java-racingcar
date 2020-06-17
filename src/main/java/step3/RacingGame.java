package step3;

import java.util.Random;
import java.util.List;

public class RacingGame {
    //  게임 진행하는 클래스 https://github.com/next-step/java-racingcar/pull/909/commits/db637e88d70bc34ed8f1c854c55e8ce82eb3a19c
    private List<RacingCar> racingCars = new ArrayList<>();
    private Random distance = new Random();

    //  게임 진행 생성자
    public RacingGame(int count) {
        for (int i = 0; i < count; i++){
            RacingCars.add(new RacingCar());
        }
    }

    //  거리 생성하는 랜덤함수
    public int randomDistance() {
        return distance.nextInt(10);
    }

    //  게임 실행하는 부분
    public List<RacingCar> playRacingGame() {
        for (RacingCar car: RacingCars){
            if(randomDistance() >= 4){
                car.move();
            }
        }
        return RacingCars;
    }

    public List<RacingCar> getRacingCarList() {
        return RacingCars;
    }
}
