package racing;

import java.util.*;

public class RacingCarServiceImpl implements RacingCarService {

    private static final int CONDITION = 4;
    private static final int BETWEEN_ZERO_AND_NINE = 10;
    private static final int MOVE = 1;
    private static Random random = new Random();


    public Map<Integer, List> racing() {
        Map<Integer, List> result = initResult();

        for(int i = 1 ; i < result.size() ; i++) {
            result.put(i, getResult(result.get(i), result.get(i-1)));
        }

        return result;
    }

    private Map<Integer, List> initResult() {
        Input input = new Input();
        Map<Integer, List> initResult = new HashMap<>();

        for(int i = 0 ; i <= input.getTimes() ; i++) {
            initResult.put(i, initLocations(input));
        }

        return initResult;
    }

    private List initLocations(Input input) {
        List<Integer> initLocations = new ArrayList<>();

        for( int i = 0 ; i < input.getCarsQuantity() ; i++) {
            initLocations.add(0);
        }

        return initLocations;
    }

    private List<Integer> getResult(List<Integer> locations, List<Integer> preLocations){
        for(int j = 0; j < locations.size() ; j++) {
            locations.set(j, moveOrStop(preLocations.get(j), getRandomNum()));
        }
        return locations;
    }

    public static int moveOrStop(int count, int number) {
        if(isSatisfiedConditionForMove(number)) {
            return count+MOVE;
        }
        return count;
    }

    public static int getRandomNum() {
        return random.nextInt(BETWEEN_ZERO_AND_NINE);
    }

    public static boolean isSatisfiedConditionForMove(int number) {
        return number >= CONDITION;
    }
}
