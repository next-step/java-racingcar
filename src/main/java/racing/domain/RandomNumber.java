package racing.domain;

import java.util.Random;

public interface RandomNumber {
    Random random = new Random();

    public int randomNumber();

}
