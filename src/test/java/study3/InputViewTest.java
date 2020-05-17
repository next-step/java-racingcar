package study3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {
	
	@Test
	@DisplayName("input과 자동차 개수가 같은지 테스트")
	void inputViewConstest() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("자동차 대수는 몇 대 인가요?");
		int value = scanner.nextInt();
		int count=0;
		for(int i=0; i<value; i++) {
			count++;
		}
		assertEquals(value, count);
	}

}
