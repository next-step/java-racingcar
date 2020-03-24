package racing.UI;

import racing.exception.OutOfBoundInputDataException;

import java.util.Scanner;

public class InputView {

	private static final int INPUT_MIN_VALUE = 1;
	
	private int cars = 0;
	private int times = 0;
	
	public void input() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("자동차 대수는 몇 대 인가요?");
		cars = scanner.nextInt();

		if ( cars < INPUT_MIN_VALUE ) {
			throw new OutOfBoundInputDataException(INPUT_MIN_VALUE);
		}
		
		System.out.println("시도할 회수는 몇 회 인가요?");
		times = scanner.nextInt();

		if ( times < INPUT_MIN_VALUE ) {
			throw new OutOfBoundInputDataException(INPUT_MIN_VALUE);
		}
	}
	
	public int getCars() {
		return cars;
	}
	
	public int getTimes() {
		return times;
	}
}
