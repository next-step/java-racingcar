import calculator.StringCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class.getName());

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String valueToCalculate = bufferedReader.readLine();
        try {
            StringCalculator stringCalculator = new StringCalculator(valueToCalculate);
            System.out.println(stringCalculator.calculate());
        } catch (IllegalArgumentException e) {
            logger.error("Input value error.", e);
        }
        bufferedReader.close();
    }
}
