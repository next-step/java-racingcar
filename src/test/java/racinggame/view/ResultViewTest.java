package racinggame.view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import racinggame.domain.Car;
import racinggame.domain.RacingResult;
import util.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static racinggame.view.ResultView.*;

public class ResultViewTest {

    private final OutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream printStream = new PrintStream(outputStream);

    @Before
    public void setUp() {
        System.setOut(printStream);
    }

    @Test
    public void showResultTitle() {
        ResultView.showResultTitle();

        assertEquals( RESULT_TITLE + System.lineSeparator(), outputStream.toString() );
    }

    @Test
    public void showCarPositions() {

        List<Car> cars = Arrays.asList(
                new Car( "pororo", 3 ),
                new Car( "pobi", 5 ),
                new Car( "crong", 7 )
        );
        RacingResult result = new RacingResult(cars);

        ResultView.showCarPositions(result);

        assertEquals( getPrintedCarListPositionString(cars), outputStream.toString() );
    }

    @Test
    public void showWinners_for_a_winner() {

        List<Car> winners = Collections.singletonList(
                new Car("pororo")
        );
        RacingResult result = new RacingResult(winners);

        showWinners(result);

        String expected = result.getDisplayableWinnerNames() + WINNING_MESSAGE + System.lineSeparator();
        assertEquals(expected, outputStream.toString());
    }

    @Test
    public void showWinners_for_two_winners() {

        List<Car> winners = Arrays.asList(
            new Car( "pororo"),
            new Car( "pobi")
        );
        RacingResult result = new RacingResult(winners);

        showWinners(result);

        String expected = result.getDisplayableWinnerNames() + WINNING_MESSAGE + System.lineSeparator();
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
        return StringUtils.repeat(POSITION_STRING, position);
    }

    @After
    public void tearDown() {
        PrintStream originalOut = System.out;
        System.setOut(originalOut);
    }
}