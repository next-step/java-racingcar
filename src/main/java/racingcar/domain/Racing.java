package racingcar.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Racing{
    private List<RacingCar> participants;
    public Racing(String[] racingCars){
        participants = new ArrayList<>();
        for(String racingCarName : racingCars){
            RacingCar racingCar = new RacingCar(racingCarName);
            participants.add(racingCar);
        }
    }

    public List<RacingCar> chooseFinalWinners(){
        int maxiMumNumber = 0;
        Map<RacingCar, Integer> rankMap = new HashMap<>();
        for(RacingCar participant : participants){
            int tempMaxiMumNumber = participant.compareRacingCarListWithNum(participants);
            if(maxiMumNumber < tempMaxiMumNumber){
                maxiMumNumber = tempMaxiMumNumber;
            }
            rankMap.put(participant, tempMaxiMumNumber);
        }
        List<RacingCar> winners = new ArrayList<>();
        for(RacingCar participant : participants){
            if(rankMap.get(participant).equals(maxiMumNumber)){
                winners.add(participant);
            }
        }
        return winners;
    }
    public void run(){
        for(RacingCar racingCar : participants){
            racingCar.run();
        }
    }

    public void runWithNoConditionAndSequence(int seq){
        participants.get(seq).runWithNoCondition();
    }


    public List<RacingCar> getParticipants(){
        return participants;
    }
}
