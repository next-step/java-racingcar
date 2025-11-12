package racinggame;

import static racinggame.car.Car.of;
import static racinggame.RandomNumberBox.getRandomNumber;
import static racinggame.ui.MC.*;
import static racinggame.ui.MC.askCarCountToUser;

import java.util.ArrayList;
import java.util.List;
import racinggame.car.Car;

public class RacingGame {

    public void start() {
        int carCount = askCarCountToUser();
        int tryCount = askTryCountToUser();

        // 자동차 대수 입력 받고 자동차 객체 필요 -> 입력 받으면 자동차 객체 생성하는 프로세스 필
        // 자동차 객체에 뭐가 필요한지 정리 필요
        // 시도 횟수만큼 반복
        // 하나의 반복에서 각 차별 프로세스 진행
        // 주사위 굴려서 전진 or 유지 결정.
        // 결정된 대로 차 상태 변경
        // 이후 각 차별 상태 출력

        // carCount와 Cars가 동시에 한 메서드에 존재할 필요가 있을까?
        // Mc에서 carCount 받자마자 Cars를 초기화 할까? -> 이걸 판단하기 위한 기준들이 뭐가 있을까?
        List<Car> cars = initCars(carCount);
        startRacing(tryCount, cars);

    }

    private void startRacing(int tryCount, List<Car> cars) {
        for (int i = 0; i < tryCount; i++) {
            // 랜덤값 구하기
            for (Car car : cars) {
                // 아래 코드의 위치가 이곳이 어울릴까요?
                // (Car.changePosition() 에서 랜덤값 추출 메서드를 직접호출해서 처리하는게 좋은지?)
                int randomNumber = getRandomNumber();
                car.changePosition(randomNumber);
            }

            printGameStates(cars);
        }
    }

    private List<Car> initCars(int carCount) {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < carCount; i++) {
            Car car = of();
            cars.add(car);
        }

        return cars;
    }
}
