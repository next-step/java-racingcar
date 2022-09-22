import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarPlayTest {

    private static CarPlay carPlay;
    private static List<Integer> carList;

    private static int cars;

    @BeforeEach
    void setTest() {
        carPlay = new CarPlay();
        carList = new ArrayList<>(Collections.nCopies(5, 0));
        cars = 5;
    }


    @Test
    public void Test1() {
        List<Integer> carList = new ArrayList<>(Collections.nCopies(5, 0));

        System.out.println(carList);
    }

    @Test
    public void Test2() {
        int res = carPlay.generateRandomNum();
        System.out.println(res);
    }

    @Test
    public void Test3() {
        boolean res = carPlay.addMoveCount();
        System.out.println(res);
    }

    @Test
    public void Test4() {
        carPlay.carMovement(carList, cars);
    }

}