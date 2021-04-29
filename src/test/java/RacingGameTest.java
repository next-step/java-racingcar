import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.Car;
import racing.RacingGame;
import racing.utils.ConvertString;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;


public class RacingGameTest {

    @Test
    @DisplayName("자동차 이름이 전부 5자 이내인 자동차 생성")
    public void makeCarTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        ConvertString convertString = new ConvertString();
        RacingGame racingGame = new RacingGame();
        Method method;
        String carString = "aaa,bbb,ccc";
        List<Car> carList;
        String[] carNameArray = convertString.splitString(carString);
        method = racingGame.getClass().getDeclaredMethod("makeCarList", String[].class);
        method.setAccessible(true);

        //when
        carList = (List<Car>) method.invoke(racingGame, (Object) carNameArray);

        //then
        Assertions.assertEquals("aaa", carList.get(0).getName());
        Assertions.assertEquals("bbb", carList.get(1).getName());
        Assertions.assertEquals("ccc", carList.get(2).getName());
    }

    @Test
    @DisplayName("자동차 이름중 일부가 5자 초과")
    public void makeCarTest2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        ConvertString convertString = new ConvertString();
        RacingGame racingGame = new RacingGame();
        Method method;
        String carString = "aaa,bbb,cccccc";
        List<Car> carList;
        String[] carNameArray = convertString.splitString(carString);
        method = racingGame.getClass().getDeclaredMethod("makeCarList", String[].class);
        method.setAccessible(true);

        //when

        //then
        //객체 생성시 글자수 오버로 IllegalArgumentException이 출력되지만 invoke 또한 되지 않아 InvocationTargetException가
        //최종적으로 출력되는 것 같아서 이렇게 테스트 코드를 작성 했는데 맞는 방법인지 모르겠습니다!!
        //원래 시도했던 문법은 InvocationTargetException.class 대신 IllegalArgumentException.class 입니다.
        org.assertj.core.api.Assertions.assertThatExceptionOfType(InvocationTargetException.class)
                .isThrownBy(() -> {
                    method.invoke(racingGame, (Object) carNameArray);
                });

    }
    @Test
    public void moveCountChangeTest() throws Exception{
        //given
        ConvertString convertString = new ConvertString();
        RacingGame racingGame = new RacingGame();
        Method method;
        String carString = "aaa,bbb,ccc";
        String[] carNameArray = convertString.splitString(carString);
        method = racingGame.getClass().getDeclaredMethod("makeCarList", String[].class);
        method.setAccessible(true);
        List<Car> carList = (List<Car>) method.invoke(racingGame, (Object) carNameArray);
        method = racingGame.getClass().getDeclaredMethod("moveCountChange", List.class);
        method.setAccessible(true);
        //when
        method.invoke(racingGame, carList);

        //then
        // 자동차별 moveCount를 증가시켜주는 moveCountChange 함수 안에서 난수가 생성되는데 만약 모든 자동차 난수가 4미만이면
        // randomCount가 증가되지 않아 모든 자동차 이동거리가 0이 되는 경우가 발생해
        // 이럴 경우는 테스트 코드를 어떻게 작성해야 하는지 모르겠습니다.
        for(int i=0; i<carList.size(); i++) {
            System.out.println(carList.get(i).getName()+": " + carList.get(i).getMoveCount());
        }
    }

}
