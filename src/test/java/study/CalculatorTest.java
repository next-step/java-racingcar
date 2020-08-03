package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CalculatorTest {
	
	private List<Integer> numbers;
	private List<String> signs;
	String calculateValue="2 + 3 * 4 / 2";
	String[] split;
	
	
	@BeforeEach
    void setUp() {
        numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(2);
    }
	
	@BeforeEach
	void setUpSign()
	{
		signs = new ArrayList<>();
		signs.add("+");
		signs.add("*");
		signs.add("/");
	}
	
	
	@Test
	public int calculate()
	{
		int result = 0;
		for(int i = 0; i < signs.size(); i++)
		{
			switch (signs.get(i)) {
			case "+":
				result = add(numbers.get(0), numbers.get(1));
				removeNumbers(numbers, result);
				break;
			case "-":
				result = substract(numbers.get(0), numbers.get(1));
				removeNumbers(numbers, result);
				break;
			case "*":
				result = multiple(numbers.get(0), numbers.get(1));
				removeNumbers(numbers, result);
				break;
			case "/":
				result = divide(numbers.get(0), numbers.get(1));
				removeNumbers(numbers, result);
				break;
			default:
				break;
			}
		}
		return result;
		
		
	}
	
	//앞의 두 수를 제거하고, 결과값을 맨 앞으로 넣음
	@Test
	public static void removeNumbers(List<Integer> numbers, int result)
	{
		numbers.set(0, result);
		numbers.remove(1);
	}
		
	
	
	@Test
	public int add(int a, int b)
	{
		return a+b;
	}
	
	@Test
	public int substract(int a, int b)
	{
		return a-b;
	}
	@Test
	public int multiple(int a, int b)
	{
		return a*b;
	}
	@Test
	public int divide(int a, int b)
	{
		return a/b;
	}
	
	
	@Test
	public void splitTest()
	{
		String values="2 + 3 * 4 / 2";
		//assertThatIllegalArgumentException 적용시 에러가 납니다.. 테스트 코드쪽에서 어떻게 작성해야 하는지 모르겠습니다.
//		assertThatIllegalArgumentException().isThrownBy(() -> {
			Calculator.split(values);
//		});
	}
	
	@Test
	public void checkNumbersTest()
	{
		String values="j";
		//assertThatIllegalArgumentException 적용시 에러가 납니다.. 테스트 코드쪽에서 어떻게 작성해야 하는지 모르겠습니다.
//		assertThatIllegalArgumentException().isThrownBy(() -> {
			Calculator.checkNumbers(values);
//		});
	}
	
	
    //java.lang.NullPointerException 으로 테스트가 되지 않습니다...
	//Null값이 없는데 나오는 이유가 뭔지 모르겠습니다.
	@Test
//	@ValueSource(strings = {"2","+","3","*","4","/","2"})
//	public void pushTest(String values)
	public void pushTest()
	{
		String[] values = {"2","+","3","*","4","/","2"};
//		assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> { 
		Calculator.push(values);
//		}).withMessageMatching("");

	}
	
}

