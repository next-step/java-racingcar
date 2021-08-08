package step4.model;

import java.util.ArrayList;
import java.util.List;

public class CarGame {
    private static Cars cars;

    /**
     * 전반적인 게임을 진행하는 메소드
     * 결과값을 '/'로 구분해서 차번호/거리 형태로 저장한다.
     * @param tryCnt
     */
    public List<String> playGame(List<String> nameList, int tryCnt) {
        //자동차 세팅
        List<Car> carList = new ArrayList<>();

        for (String name : nameList){
            carList.add(new Car(name));
        }

        cars = new Cars(carList);

        //결과값
        List<String> results = new ArrayList<>();

        while (tryCnt-- > 0) {
            RandomMovingStrategy strategy = new RandomMovingStrategy();
            List<Car> result = cars.moveAll(strategy);
            formatResult(results, result);
        }

        return results;
    }

    private void formatResult(List<String> results, List<Car> result) {
        for (Car car : result) {
            Name carName = car.getName();
            Position carPosition = car.getPosition();
            results.add(carName.getName() + "/" + carPosition.getPosition());
        }
    }


    /**
     * 우승자 이름 리스트를 반환한다.
     * @return
     */
    public List<String> getWinner() {
        return cars.getTopMoveCar();
    }
}
