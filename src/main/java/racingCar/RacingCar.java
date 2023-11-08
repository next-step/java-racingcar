package racingCar;

public class RacingCar {

    public static int moveCar(int randomValue){
        if(randomValue<=3) return 0;
        return 1;
    }

    public static int[] addMoving(int[] carArray){
        for (int i=0; i<carArray.length; i++){
            carArray[i] += moveCar(RandomNumber.getRandom(10));
        }

        return carArray;
    }
}
