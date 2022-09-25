package step2;

import step2.calculated.Calculated;
import step2.calculated.CalculatedString;
import step2.parsed.ParsedStringByCustomDelimiter;
import step2.parsed.ParsedStringByDefaultDelimiter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Client {

    private static final Pattern CUSTOM_DELIMITER_JUDGMENT = Pattern.compile("(//.*\n).*[0-9].*");

    public static void main(String[] args) {
        int calculated = calculated();
        System.out.println("calculated = " + calculated);
    }

    private static int calculated() {
        String inputValue = "";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            inputValue = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (inputValue == null) {
            Calculated calculated = new CalculatedString(new ParsedStringByDefaultDelimiter(inputValue));
            return calculated.calculatedResult();
        }

        if (CUSTOM_DELIMITER_JUDGMENT.matcher(inputValue).find()) {
            Calculated calculated = new CalculatedString(new ParsedStringByCustomDelimiter(inputValue));
            return calculated.calculatedResult();
        }

        Calculated calculated = new CalculatedString(new ParsedStringByDefaultDelimiter(inputValue));
        return calculated.calculatedResult();
    }

}
