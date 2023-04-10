package racingcar.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static racingcar.service.RacingCar.go;

public class ResultView {
    private final Random random = new Random();
    
    public void view(List<Integer> input) {
        Map<Integer, Integer> carState = new HashMap<>();
        initCarState(carState, input.get(0));
        
        System.out.println();
        System.out.println("실행 결과");
        race(input, carState);
    }

    private void race(List<Integer> input, Map<Integer, Integer> carState) {
        for (int race = 0; race < input.get(1); race++) {
            carStateCheck(input, carState);
            System.out.println();
        }
    }

    private void carStateCheck(List<Integer> input, Map<Integer, Integer> carState) {
        for(int car = 0; car < input.get(0); car++){
            makeCarState(carState, car);
            System.out.println("-".repeat(carState.get(car)));
        }
    }

    private void makeCarState(Map<Integer, Integer> carState, int car) {
        if(go(random.nextInt(10))) {
            carState.put(car, carState.get(car) + 1);
        }
    }

    public void initCarState(Map<Integer, Integer> carState, int carNumber){
        for(int i = 0; i < carNumber; i++){
            carState.put(i, 0);
        }
    }
}
