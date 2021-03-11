package step3.racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

//Q. 아래의 테스트는 작동이 안되는데, Scanner(System.in) 생성 시점과 System.setIn을 해주는 시점이 달라서 그런걸까요?
//  InputView.input() 호출 후에 setIn을 해줘도 동일하게 안됩니다.. System.setIn을 적용시켜주는 테스트는 어려울까요?
//참고 : https://stackoverflow.com/questions/6415728/junit-testing-with-simulated-user-input
class InputViewTest {
    private String[] strs;
    private static final String CARNUM = "4";
    private static final String TRYNUM = "3";

    @BeforeEach
    void setUp(){
        strs = new String[]{"자동차 대수는 몇 대 인가요?", "시도할 회수는 몇 회 인가요?"};
        System.setIn(new ByteArrayInputStream(CARNUM.getBytes()));
        System.setIn(new ByteArrayInputStream(TRYNUM.getBytes()));
    }

    @Test
    void inputTest(){
        ArrayList<Integer> result = InputView.input(strs);
        assertThat(result).contains(Integer.parseInt(CARNUM), Integer.parseInt(TRYNUM));
    }
}
