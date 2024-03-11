package carRace;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Car implements Runnable{

    private static final int RECORD_STANDARD_NUMBER = 4;

    private List<Integer> randomNumberHistory = new ArrayList<>();

    private StringBuffer raceResult = new StringBuffer();

    public static List<Car> createCar(int carMount){
        return IntStream.range(0, carMount)
            .mapToObj(i -> new Car())
            .collect(Collectors.toList());
    }

    public List<Integer> randomNumberHistory(){
        return randomNumberHistory;
    }

    public String raceResult(){
        return raceResult.toString();
    }

    @Override
    public void run() {
        int randomNumber = RandomNumberGenerator.createRandomNumber();
        randomNumberHistory.add(randomNumber);
        if (isCarRunning(randomNumber)){
            raceResult.append("_");
        }
    }

    private boolean isCarRunning(int randomNumber){
        if (randomNumber >= RECORD_STANDARD_NUMBER) {
            return true;
        }
        return false;
    }

    public void printRaceResult(){
        System.out.println(raceResult.toString());
    }
}
