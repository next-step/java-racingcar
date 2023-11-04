package carRacing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRacingGame {

    public static final int MAX = 10;
    private final int carCount;
    private final int raceCount;
    List<Integer> carList = new ArrayList<>();

    public CarRacingGame(int carCount, int raceCount) {
        this.carCount = carCount;
        this.raceCount = raceCount;
    }

    //전체 레이싱 게임 진

    public void startGame(){
        init();
        for(int i=0;i<raceCount;i++){
            round();
            ResultView.printRoundResult(carList);
        }
    }

    //라운드별 경주
    public List<Integer> round(){

        for(int c=0;c<carList.size();c++){
            if(isRide(random())){ //랜덤 값 때문에 test 어려움...
                move(c);
            }
        }

        return carList;
    }

    public void init(){
        int distance = 0;
        for(int i=0;i<carCount;i++){
            carList.add(distance);
        }
    }

    public void move(int c) {
        carList.set(c,carList.get(c)+1);
    }



    public List<Integer> showCarList(){
        return carList;
    }

    //자동자 전진 로직


    public boolean isRide(int number){
        if(number<4){
            return false;
        }
        return true;
    }

    public int random(){
        Random random = new Random();
        return random.nextInt(MAX);
    }


}
