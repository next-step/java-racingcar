package carRacing.service;

import carRacing.dto.UserInput;

public class JudgeService {

    public boolean isGameOver(UserInput userInput){
        return userInput.getNumberOfRace()<=0;
    }

    public UserInput checkRemainingRace(UserInput userInput){
        return new UserInput(userInput.getNumberOfCars(), userInput.getNumberOfRace()-1);
    }

}
