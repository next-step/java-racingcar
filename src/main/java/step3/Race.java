package step3;


import step3.util.NumberGenerator;
import step3.util.RandomNumberGenerator;

public class Race {

    private final NumberGenerator numberGenerator = new RandomNumberGenerator();

    public Car[] generateCarArray(int carCount){
        Car[] carArray = new Car[carCount];
        for (int index = 0; index < carCount; index++) {
            carArray[index] = new Car();
        }
        return carArray;
    }

    public void startMoving(Car[] carArray){
        for (int i = 0; i < carArray.length; i++) {
            System.out.println(carArray[i].getPosition());
            int chance = numberGenerator.generate();
            carArray[i].move(chance);
        }
        System.out.println();
    }
}