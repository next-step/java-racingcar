import CarRacing.*;

import static java.lang.System.exit;

public class Application {

    private static final Integer NORMAL_RETURN = 0;

    public static void main(String[] args) {
        Racing racing = new Racing();

        try {
            racing.Competition(null,null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        exit(NORMAL_RETURN);
    }
}
