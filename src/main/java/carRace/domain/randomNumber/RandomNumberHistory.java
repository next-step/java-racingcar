package carRace.domain.randomNumber;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberHistory {

    List<RandomNumber> randomNumbers = new ArrayList<>();

    public List<RandomNumber> getRandomNumbers() {
        return randomNumbers;
    }

    public void addRandomNumber(RandomNumber randomNumber){
        randomNumbers.add(randomNumber);
    }
}
