package step1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 사용자 입력을 받는다
		Scanner scanner = new Scanner(System.in);
		String inputString = scanner.nextLine();

		/**
		 * 고민거리
		 * Main 클래스는 파서와 계산기에 대해 의존하고 있습니다.
		 * 의존성을 줄이기 위한 두 가지 방법이 떠오르는데 어떤 방법이 좋을지, 아니면 굳이 의존성을 줄여야 할지에 대해 판단이 어렵습니다.
		 * 우선 두 가지 방법은 이렇습니다
		 *
		 * 1) SequentialCalculator가 Parser를 가지고 있도록 한다
		 *    의존성 방향 : Main > SequentialCalculator > Parser
		 *    계산기의 책임을 어디까지 볼 것인가에 대한 의구심이 존재, 파싱도하고 계산도 해야 하는가
		 *
		 * 2) 기존의 SequentialCalculator를 CalculatorCore로 바꾸고
		 *    SequentialCalculator가 Parser와 CalculatorCore를 가지고 있도록 한다
		 *    의존성 방향 : Main > SequentialCalculator > Parser + CalculatorCore
		 *    계산기라는 모듈이 전처리를 담당하는 파싱 객체과 계산을 담당하는 코어 객체를 가지고 있는 그림이 맞아 보이지만
		 *    이렇게 까지 해야 할까에 대한 의구심이 존재
		 *
		 * 피드백 주시면 감사하겠습니다!!
		 */
		try {
			// 파싱하고 결과를 출력한다
			Parser parser = new Parser(inputString);
			SequentialCalculator calculator = new SequentialCalculator(parser.getNumbers(), parser.getOperators());
			System.out.println(String.format("결과는 %s 입니다", calculator.getResult().toPlainString()));
		} catch (IllegalArgumentException e) {
			System.out.println("입력한 문자열을 확인해 주세요");
		}
	}

}
