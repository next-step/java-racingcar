package racingcar.ui.view;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import racingcar.domain.RacingResult;

import static java.util.stream.Collectors.toList;

class MotorRacingDisplayWinnerResults {
    public static final String ROUND_RESULT_SEPARATOR = "\n\n";
    private Map<String, Integer> winners;

    public MotorRacingDisplayWinnerResults() {
        this.winners = new LinkedHashMap<>();
    }

    public void accumulateRacingTotalMileage(RacingResult racingResult){
        if(racingResult.isEmptyPrefix()){
            return;
        }
        String carName = racingResult.getPrefix();
        int currentTotalMileage = racingResult.getTotalMileage();
        registerRacingCar(carName);
        accumulate(carName, currentTotalMileage);
    }

    private void registerRacingCar(String carName){
        if(!winners.containsKey(carName)){
            winners.put(carName, 0);
        }
    }

    private void accumulate(String carName, int currentTotalMileage) {
        if(winners.containsKey(carName)){
            int beforeTotalMileage = winners.get(carName);
            winners.put(carName, currentTotalMileage + beforeTotalMileage);
        }
    }

    @Override
    public String toString() {
        return winners.toString();
    }

    int getMaxTotalMileage(){
        return Collections.max(winners.values());
    }

    boolean isMaxTotalMileage(int totalMileage){
        return totalMileage == getMaxTotalMileage();
    }

    List<String> getWinners(){
        return winners.entrySet().stream()
               .filter(e -> isMaxTotalMileage(e.getValue()))
               .map(Map.Entry::getKey)
               .collect(toList());
    }
}
