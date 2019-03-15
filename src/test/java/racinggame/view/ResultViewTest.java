package racinggame.view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import racinggame.domain.Car;
import racinggame.domain.RacingResult;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static racinggame.view.ResultView.*;

public class ResultViewTest {

    private OutputStream outputStream = new ByteArrayOutputStream();
    private PrintStream printStream = new PrintStream(outputStream);
    private ResultView  resultView = new ResultView();

    @Before
    public void setUp() throws Exception {
        System.setOut(printStream);
    }

    @Test
    public void showResultTitle() {
        String output = RESULT_TITLE;

        resultView.showResultTitle();

        assertEquals( output + System.lineSeparator(), outputStream.toString() );
    }

    @Test
    public void showCarPosition() {
        String carName = "pororo";
        int position = 5;
        Car car = new Car( carName, position );

        resultView.showCarPosition(car);

        assertEquals( carName + " : " + getPositionString(position) + System.lineSeparator(), outputStream.toString() );
    }

    @Test
    public void showCarPositions() {

        List<Car> cars = Arrays.asList(
                new Car( "pororo", 3 ),
                new Car( "pobi", 5 ),
                new Car( "crong", 7 )
        );
        RacingResult result = new RacingResult(cars);

        resultView.showCarPositions(result);

        assertEquals( getPrintedCarListPositionString(cars), outputStream.toString() );
    }

    @Test
    public void getWinnerListString_for_a_winner() {

        List<Car> winners = Arrays.asList(
            new Car( "pororo")
        );
        RacingResult result = new RacingResult(winners);

        String expected = winners.get(0).getName();
        String actual = resultView.getWinnersString(result);

        assertEquals(expected, actual);
    }

    @Test
    public void getWinnerListString_for_two_winners() {

        List<Car> winners = Arrays.asList(
                new Car( "pororo"),
                new Car( "pobi")
        );
        RacingResult result = new RacingResult(winners);

        String expected = winners.get(0).getName() + WINNER_SEPARATOR + winners.get(1).getName();
        String actual = resultView.getWinnersString(result);

        assertEquals(expected, actual);
    }

    @Test
    public void showWinners_for_a_winner() {

        List<Car> winners = Arrays.asList(
            new Car( "pororo")
        );
        RacingResult result = new RacingResult(winners);

        resultView.showWinners(result);

        String expected = resultView.getWinnersString(result) + WINNING_MESSAGE + System.lineSeparator();
        assertEquals(expected, outputStream.toString());
    }

    @Test
    public void showWinners_for_two_winners() {

        List<Car> winners = Arrays.asList(
            new Car( "pororo"),
            new Car( "pobi")
        );
        RacingResult result = new RacingResult(winners);

        resultView.showWinners(result);

        String expected = resultView.getWinnersString(result) + WINNING_MESSAGE + System.lineSeparator();
        assertEquals(expected, outputStream.toString() );
    }

    private String getPrintedCarListPositionString(List<Car> cars) {

        StringBuilder sb = new StringBuilder();

        for( Car curCar : cars ) {
            sb.append(curCar.getName());
            sb.append(" : ");
            sb.append(getPositionString(curCar.getPosition()));
            sb.append(System.lineSeparator());
        }
        sb.append(System.lineSeparator());

        return sb.toString();
    }

    private String getPositionString( int position ) {

        StringBuilder sb = new StringBuilder();

        for( int i = 0; i < position; ++i ) {
            sb.append(POSITION_STRING);
        }

        return sb.toString();
    }

    @After
    public void tearDown() throws Exception {
        PrintStream originalOut = System.out;
        System.setOut(originalOut);
    }
}