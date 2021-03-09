package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RuleTest {

  @Test
  @DisplayName("정적 메소드를 통해서 생성할 수 있는가")
  public void createRuleUsingStaticMethod() throws Exception {
    //given
    Cars cars = new Cars(createCarForTest());
    int round = 5;

    //when
    Rule rule = Rule.createRule(round, cars);

    //then
    assertAll(
        () -> assertEquals(round, rule.getRound()),
        () -> assertEquals(cars, rule.getCars())
    );
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
  @DisplayName("주어진 값과 비교하여 움직일지 말지 제대로 비교할 수 있는가")
  public void movableCarByCreatedNumber(int testCase) throws Exception {
    //given
    final int MOVEABLE_CRITERIA = 4;

    Cars cars = new Cars(createCarForTest());
    int round = 5;

    Rule rule = Rule.createRule(round, cars);

    //when
    Method method = rule.getClass().getDeclaredMethod("isMoveable", int.class);
    method.setAccessible(true);

    //then
    boolean actualMoveable = testCase <= MOVEABLE_CRITERIA;
    boolean expectedMoveable = (boolean) method.invoke(rule, testCase);

    assertEquals(actualMoveable, expectedMoveable);
  }

  @Test
  @DisplayName("생성된 난수와 비교하여 움직일지 말지 제대로 비교할 수 있는가")
  public void movableCarByCreatedRandomNumber() throws Exception {
    //given
    final int MOVEABLE_CRITERIA = 4;
    final int RANDOM_NUMBER_BOUND = 10;

    Cars cars = new Cars(createCarForTest());
    int round = 5;

    Rule rule = Rule.createRule(round, cars);

    //when
    Field field = rule.getClass().getDeclaredField("randomNumber");
    field.setAccessible(true);

    Method method = rule.getClass().getDeclaredMethod("isMoveable", int.class);
    method.setAccessible(true);

    Random generatedRandomSeed = (Random) field.get(rule);
    int randomNumber = generatedRandomSeed.nextInt(RANDOM_NUMBER_BOUND);

    //then
    boolean actualMoveable = randomNumber <= MOVEABLE_CRITERIA;
    boolean expectedMoveable = (boolean) method.invoke(rule, randomNumber);

    assertEquals(actualMoveable, expectedMoveable);
  }

  public static List<Car> createCarForTest() {
    List<Car> carList = new ArrayList<>();
    for(int i = 0; i < 3; i++) {
      carList.add(Car.createCar());
    }
    return carList;
  }
}