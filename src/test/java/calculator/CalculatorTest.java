package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

  @Before
  public void setUp() throws Exception {
    System.out.println("setUp");
  }

  @Test
  public void 덧셈() {

    System.out.println("add");
    int result = Calculator.add(1, 2);
    assertThat(result).isEqualTo(3);
  }

  @Test
  public void 뺄셈() {

    System.out.println("subtract");
    int result = Calculator.substract(2, 1);
    assertThat(result).isEqualTo(1);
  }

  @After
  public void tearDown() throws Exception {
    System.out.println("tearDown");
  }
}
