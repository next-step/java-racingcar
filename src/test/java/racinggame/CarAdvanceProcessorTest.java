package racinggame;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mock;

public class CarAdvanceProcessorTest {

    private CarAdvanceProcessor processor;
    private Random random;

    @Before
    public void setUp() throws Exception {
        processor = new CarAdvanceProcessor();
        random = mock(Random.class);
        processor.setRandom(random);
    }

    @Test
    public void test_when_random_value_equals_or_is_greater_than_4() {

        int [] randomValues = new int [] { 4, 5, 6, 7, 8, 9 };
        int curPosition = 1;

        for( int randomValue : randomValues ) {
            when(processor.getRandom().nextInt(10)).thenReturn(randomValue);
            assertEquals(true, processor.isMovingForward());
            assertEquals( curPosition+1, processor.getNextPosition(curPosition) );
        }
    }

    @Test
    public void test_when_random_value_is_less_than_4() {

        int [] randomValues = new int [] { 0, 1, 2, 3 };
        int curPosition = 3;

        for( int randomValue : randomValues ) {
            when(processor.getRandom().nextInt(10)).thenReturn(randomValue);
            assertEquals(false, processor.isMovingForward());
            assertEquals( curPosition, processor.getNextPosition(curPosition) );
        }
    }

    @Test
    public void moveForward_succeeded() {

        int [] actualPositions = new int [] { 1, 2, 3 };
        int [] expectedPositions = new int [] { 2, 3, 4 };

        when(processor.getRandom().nextInt(10)).thenReturn(9);
        processor.moveForward(actualPositions);

        for( int i = 0, length = actualPositions.length; i < length; ++i ) {
            assertEquals( expectedPositions[i], actualPositions[i] );
        }
    }


    @Test
    public void moveForward_failed() {

        int [] actualPositions = new int [] { 1, 2, 3 };
        int [] expectedPositions = new int [] { 1, 2, 3 };

        when(processor.getRandom().nextInt(10)).thenReturn(0);
        processor.moveForward(actualPositions);

        for( int i = 0, length = actualPositions.length; i < length; ++i ) {
            assertEquals( expectedPositions[i], actualPositions[i] );
        }
    }

}