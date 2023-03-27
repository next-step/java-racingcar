package racingcar.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Racing{
    private List<RacingCar> participants;
    private Map<RacingCar, Integer> rankMap;
    private List<RacingCar> winners;

    public Racing(String[] racingCars){
        participants = new ArrayList<>();
        for(String racingCarName : racingCars){
            RacingCar racingCar = new RacingCar(racingCarName);
            participants.add(racingCar);
        }
    }

    public Racing(String[] racingCars, int[] racingCarsRunCounts){
        participants = new ArrayList<>();
        for(int i=0;i<racingCars.length;i++){
            String racingCarName = racingCars[i];
            int  runCount = racingCarsRunCounts[i];
            RacingCar racingCar = new RacingCar(racingCarName, runCount);
            participants.add(racingCar);
        }
    }

    public List<RacingCar> chooseFinalWinners(){
        rankMap = new HashMap<>();
        int maxiMumNumber = 0;
        for(RacingCar participant : participants){
            int tempMaxiMumNumber = 0;
            tempMaxiMumNumber = participant.compareRacingCarListWithNum(participants, tempMaxiMumNumber);
            memoMaximumNumber(maxiMumNumber, tempMaxiMumNumber);
            rankMap.put(participant, tempMaxiMumNumber);
        }
        winners = new ArrayList<>();
        for(RacingCar participant : participants){
            memoWinner(participant, maxiMumNumber);
        }
        return winners;
    }

    private void memoMaximumNumber(int maxiMumNumber, int tempMaxiMumNumber){
        if(maxiMumNumber < tempMaxiMumNumber){
            maxiMumNumber = tempMaxiMumNumber;
        }
    }

    private void memoWinner(RacingCar participant, int maxiMumNumber){
        if(rankMap.get(participant).equals(maxiMumNumber)){
            winners.add(participant);
        }
    }

    public void run(){
        for(RacingCar racingCar : participants){
            racingCar.run();
        }
    }


    public List<RacingCar> getParticipants(){
        return participants;
    }
}
