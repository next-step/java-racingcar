package racingCar;

public class RacingCar {
    public static final int FORWRARD_BOUNDARY_VALUE = 3;
    public static final int RANDOM_LIMIT_VALUE = 10;

    public static void main(String[] args) {
        int[] inputValues = InputView.input();
        int carNum = inputValues[0];
        int tryNum = inputValues[1];

        Cars cars = new Cars(carNum);

        movingResult(cars.carArray, tryNum);

    }

    public static int moveCar(int inputValue){
        if(inputValue<=FORWRARD_BOUNDARY_VALUE) return 0;
        return 1;
    }

    public static int[] addMoving(int[] carArray){
        for (int i=0; i<carArray.length; i++){
            carArray[i] += moveCar(RandomNumber.getRandom(RANDOM_LIMIT_VALUE));
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
