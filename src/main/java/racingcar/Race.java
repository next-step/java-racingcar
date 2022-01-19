package racingcar;

public class Race {
    public int getRandomNumber(){
        int randomNumber = (int) Math.floor(Math.random()*10);
        return randomNumber;
    }
    public void compareWithFour(int[] cars, int idx, int randomNumber){
        if(randomNumber>=4)
            cars[idx]++;
        return;
    }
}
