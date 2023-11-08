package racingCar;

public class RacingCar {

    public static void main(String[] args) {
        int[] inputValues = InputView.input();
        int carNum = inputValues[0];
        int tryNum = inputValues[1];

        Cars cars = new Cars(carNum);

        movingResult(cars.carArray, tryNum);

    }

    public static int moveCar(int randomValue){
        if(randomValue<=3) return 0;
        return 1;
    }

    public static int[] addMoving(int[] carArray){
        for (int i=0; i<carArray.length; i++){
            carArray[i] += moveCar(RandomNumber.getRandom(10));
            ResultView.print(carArray[i]);
        }

        return carArray;
    }

    public static int[] movingResult(int[] carArray, int tryNum){
        for(int i=0; i<tryNum; i++){
            addMoving(carArray);
            System.out.println();
        }

        return carArray;
    }
}
