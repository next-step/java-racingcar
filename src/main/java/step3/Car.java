package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {
    private int position = 0;
    private List<Round> roundInfoList = new ArrayList<Round>();

    public void playRound(int roundTime) {
        Round round = new Round();

        round.setTime(roundTime);
        round.setRandomNumber(generateRandomValue());

        if(generateRandomValue() >=  4) {
            this.position++;
        }
        round.setPosition(this.position);

        this.roundInfoList.add(round);
    }

    private static int generateRandomValue() {
        Random generator = new Random();

        int randomValue = generator.nextInt(10);
        ValidationUtils.validateRandomValue(randomValue);

        return randomValue;
    }

    public List<Round> getRoundInfoList() {
        return this.roundInfoList;
    }
}
