package step3;

import java.util.List;
import java.util.stream.Collectors;

public class RaceResult {

    /**
     * 자동차경주에 참여한 cars 중 우승자를 돌려준다
     * @param cars
     * @return
     */
    public List<Car> findRaceWinners(List<Car> cars){
        int winningNumber = cars.stream().map(it -> it.getMovingDistance()).max(Integer::compareTo).get();
        return cars.stream()
                .filter( it -> it.getMovingDistance() == winningNumber )
                .collect(Collectors.toList());
    }
}
