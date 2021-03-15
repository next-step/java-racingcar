package ch01.step2;

import java.util.Random;

public class RacingGame {

    int attemptCount = 0;
    int carCount = 0;
    String[] progressArr;
    void execute(){
        InputView iv = new InputView();
        this.attemptCount = iv.getAttemptCount();
        this.carCount = iv.getCarCount();
        this.progressArr = iv.getProgressArr();
        while(attemptCount-- > 0){
            racing();
        }
    }

    public void racing(){
        int randomNumber = 0;
        int progressArrSize = progressArr.length;
        for(int i=0; i< progressArrSize; i++){
            randomNumber = getRandomNumber();


            if(isKeepGoing(randomNumber)){
                progressArr[i] += "-";
            }
        }
    }

    public void moveCar(int index){
        progressArr[index] +="-";
    }
    public boolean isKeepGoing(int randomNumber){
        return randomNumber > 3;
    }

    public int getRandomNumber(){
        return new Random().nextInt(10);
    }
    public static void main(String[] args) {
        new RacingGame().execute();
    }
}
