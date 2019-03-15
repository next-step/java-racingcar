package racinggame.view;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class InputViewTest {

    private Scanner scanner;

    private InputView inputView;

    @Test
    public void test_carNames_when_there_is_no_input() {
        prepareInputString("\r\n");

        String inputLine = scanner.nextLine();
        System.out.println(inputLine);
        String [] carNames = inputView.getCarNames(inputLine);

        assertNotNull( carNames );
        assertEquals( 1, carNames.length );
        assertEquals( "", carNames[0] );
    }


    @Test(expected = InputMismatchException.class)
    public void test_validatedCarNames_when_there_is_no_input() {
        prepareInputString("\r\n");

        String inputLine = scanner.nextLine();
        System.out.println(inputLine);
        String [] carNames = inputView.getCarNames(inputLine);

        inputView.validateCarNames(carNames);
    }

    @Test
    public void test_carNames_when_there_is_an_input() {
        String carName = "pororo";
        prepareInputString(carName + "\r\n");

        String inputLine = scanner.nextLine();
        System.out.println(inputLine);
        String [] carNames = inputView.getCarNames(inputLine);

        assertNotNull( carNames );
        assertEquals( 1, carNames.length );
        assertEquals( carName, carNames[0] );
    }

    @Test
    public void test_validatedCarNames_for_wrong_delimeter() {
        String carName1 = "pororo";
        String carName2 = "pobi";
        prepareInputString(carName1 + " " + carName2 + "\r\n");

        String inputLine = scanner.nextLine();
        System.out.println(inputLine);
        String [] carNames = inputView.getCarNames(inputLine);

        assertNotNull( carNames );
        assertEquals( 1, carNames.length );
        assertEquals( carName1 + " " + carName2, carNames[0] );
    }

    @Test
    public void test_validatedCarNames_for_two_cars() {
        String carName1 = "pororo";
        String carName2 = "pobi";
        prepareInputString(carName1 + "," + carName2 + "\r\n");

        String inputLine = scanner.nextLine();
        System.out.println(inputLine);
        String [] carNames = inputView.getCarNames(inputLine);

        assertNotNull( carNames );
        assertEquals( 2, carNames.length );
        assertEquals( carName1, carNames[0] );
        assertEquals( carName2, carNames[1] );
    }

    @Test
    public void test_validatedCarNames_when_there_are_three_cars() {
        String carName1 = "pororo";
        String carName2 = "pobi";
        String carName3 = "crong";
        String cars = carName1 + "," + carName2 + "," + carName3;
        prepareInputString( cars + "\r\n");

        String inputLine = scanner.nextLine();
        System.out.println(inputLine);
        String [] carNames = inputView.getCarNames(inputLine);

        assertNotNull( carNames );
        assertEquals( 3, carNames.length );
        assertEquals( carName1, carNames[0] );
        assertEquals( carName2, carNames[1] );
        assertEquals( carName3, carNames[2] );
    }

    @Test
    public void test_getNumberOfTries_for_no_input() {
        prepareInputString("\r\n");

        String inputLine = scanner.nextLine();
        System.out.println(inputLine);
        Integer numberOfTries = inputView.getNumberOfTries(inputLine);

        assertNull( numberOfTries );
    }

    @Test
    public void test_getNumberOfTries_for_string_input() {
        String input = "abc";
        prepareInputString(input + "\r\n");

        String inputLine = scanner.nextLine();
        System.out.println(inputLine);
        Integer numberOfTries = inputView.getNumberOfTries(inputLine);

        assertNull( numberOfTries );
    }

    @Test
    public void test_getNumberOfTries_for_negative_integer() {
        Integer negative = -1;
        prepareInputString(negative + "\r\n");

        String inputLine = scanner.nextLine();
        System.out.println(inputLine);
        Integer numberOfTries = inputView.getNumberOfTries(inputLine);

        assertEquals( negative, numberOfTries );
    }

    @Test
    public void test_getNumberOfTries_for_successful_case() {
        Integer integer = 9;
        prepareInputString(integer + "\r\n");

        String inputLine = scanner.nextLine();
        System.out.println(inputLine);
        Integer numberOfTries = inputView.getNumberOfTries(inputLine);

        assertEquals( integer, numberOfTries );
    }

    @Test(expected = InputMismatchException.class)
    public void test_validateNumberOfTries_for_no_input() {
        prepareInputString("\r\n");

        String inputLine = scanner.nextLine();
        System.out.println(inputLine);
        Integer numberOfTries = inputView.getNumberOfTries(inputLine);

        inputView.validateNumberOfTries(numberOfTries);
    }

    @Test(expected = InputMismatchException.class)
    public void test_validateNumberOfTries_for_negative_integer() {
        prepareInputString("-9\r\n");

        String inputLine = scanner.nextLine();
        System.out.println(inputLine);
        Integer numberOfTries = inputView.getNumberOfTries(inputLine);

        inputView.validateNumberOfTries(numberOfTries);
    }

    @Test(expected = InputMismatchException.class)
    public void test_validateNumberOfTries_for_string_input() {
        prepareInputString("abc\r\n");

        String inputLine = scanner.nextLine();
        System.out.println(inputLine);
        Integer numberOfTries = inputView.getNumberOfTries(inputLine);

        inputView.validateNumberOfTries(numberOfTries);
    }

    public void prepareInputString(String inputString) {
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(inputString.getBytes()));
            scanner = new Scanner(System.in);
            inputView = new InputView(scanner);
        } finally {
            System.setIn(stdin);
        }
    }
}