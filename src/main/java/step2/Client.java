package step2;

import step2.calculated.Calculated;
import step2.calculated.CalculatedString;
import step2.parsed.ParsedStringByDelimiterService;
import step2.parsed.ParsedStringByDelimiterUseCase;

import java.io.IOException;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String stringToBeParsed = sc.nextLine();

        ParsedStringByDelimiterUseCase stringByDelimiterUseCase = new ParsedStringByDelimiterService(stringToBeParsed);
        Calculated calculated = new CalculatedString(stringByDelimiterUseCase.parsedString());
        int result = calculated.calculatedResult();

        System.out.println("result = " + result);
    }

}
