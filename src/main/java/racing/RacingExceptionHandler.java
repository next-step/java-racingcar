package racing;

import racing.exception.RacingBaseException;

public class RacingExceptionHandler {
    public void exceptionHandle() {
        try {
            new RacingApplication().run();
        } catch (RacingBaseException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
