package racing;

import racing.exception.RacingBaseException;

public class RacingExceptionHandler {
    private final RacingApplication racingApplication;

    public RacingExceptionHandler(final RacingApplication racingApplication) {
        this.racingApplication = racingApplication;
    }

    public void exceptionHandle() {
        try {
            racingApplication.run();
        } catch (RacingBaseException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
