package step3;

import java.util.List;
import java.util.stream.Collectors;

public class RaceWinnerFinder {

    /**
     * 자동차경주에 참여한 cars 중 우승자를 찾아준다
     * @param cars
     * @return
     */
    public List<Car> find(List<Car> cars){
        List<CarState> states = cars.stream().map( it -> CarState.of(it) ).collect(Collectors.toList());

        int winningNumber = states.stream()
                .map( it -> it.getMovingDistance() )
                .max(Integer::compareTo).get();
        return states.stream()
                .filter( it -> it.getMovingDistance() == winningNumber )
                .map( it -> it.getCar() )
                .collect(Collectors.toList());
    }

}
