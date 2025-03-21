package racing;

import racing.domain.RacingCarService;

public class RacingCarMain {
    public static void main(String[] args) {
        RacingCarService racingCarService = new RacingCarService();
        racingCarService.start();
    }
}
