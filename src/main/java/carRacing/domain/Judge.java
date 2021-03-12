package carRacing.domain;

import carRacing.dto.UserInput;

public class Judge {

    private int count;

    public Judge() {
        this.count = 0;
    }

    public boolean isGameOver(UserInput userInput){
        return userInput.getNumberOfRace()<=this.count;
    }

    public void recordTime(){
        this.count+=1;
    }

    public int getCount() {
        return count;
    }
}
