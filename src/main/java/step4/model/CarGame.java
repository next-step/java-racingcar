package step4.model;

import java.util.ArrayList;
import java.util.List;

public class CarGame {
    public static Cars cars;
    /**
     * 전반적인 게임을 진행하는 메소드
     * 결과값을 '/'로 구분해서 차번호/거리 형태로 저장한다.
     * @param tryCnt
     */
    public List<String> playGame(List<String> nameList, int tryCnt) {
        //자동차 세팅
        cars = new Cars(nameList);

        //결과값
        List<String> results = new ArrayList<>();

        while (tryCnt-- > 0) {
            RandomMovingStrategy strategy = new RandomMovingStrategy();
            List<String> result = cars.moveAll(strategy);
            results.addAll(result);
        }

        return results;
    }

    /**
     * 우승자 이름 리스트를 반환한다.
     * @return
     */
    public List<String> getWinner() {
        return cars.getTopMoveCar();
    }
}
