package carRacing.service;

import carRacing.dto.UserInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RaceService {

    public List<String> prepareScoreboard(UserInput userInput){
        List<String> scoreboard = new ArrayList<>();
        int numberOfCars = userInput.getNumberOfCars();
        while(numberOfCars>0){
            scoreboard.add("\uD83D\uDE98");
            numberOfCars-=1;
        }
        return scoreboard;
    }

    public List<String> updateScoreboard(List<String> scoreboard){
        return scoreboard.stream()
                .map(this::raceOrStay)
                .collect(Collectors.toList());
    }

    public String raceOrStay(String score){
        Random random = new Random();
        if(random.nextInt(10)>=4) return score+"-";
        return score;
    }
}
