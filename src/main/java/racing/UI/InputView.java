package racing.ui;

import racing.exception.EmptyInputDataException;
import racing.exception.OutOfBoundInputDataException;
import racing.object.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

	private static final String TOKEN_SPLIT_FOR_CAR_LIST = ",";
	private static final int INPUT_MIN_VALUE = 1;
	
	private String[] cars;
	private int times = 0;
	
	public void input() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		String carList = scanner.nextLine();
		
		if ( carList == null || carList.trim().isEmpty() ) {
			throw new EmptyInputDataException();
		}
		
		cars = carList.split(TOKEN_SPLIT_FOR_CAR_LIST);
		
		System.out.println("시도할 회수는 몇 회 인가요?");
		times = scanner.nextInt();

		if ( times < INPUT_MIN_VALUE ) {
			throw new OutOfBoundInputDataException(INPUT_MIN_VALUE);
		}
	}
	
	public String[] getCars() {
		return cars;
	}
	
	public int getTimes() {
		return times;
	}
}
