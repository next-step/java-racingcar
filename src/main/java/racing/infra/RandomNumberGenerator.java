package racing.infra;

import java.security.SecureRandom;

public class RandomNumberGenerator {
    private SecureRandom secureRandom = new SecureRandom();

    public int generate(){
        return secureRandom.nextInt(9) + 1;
    }
}
