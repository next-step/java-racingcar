package study3;

import java.util.Arrays;

/*
 *  Output UI 출력
 *  author : choi 
 */
public class OutputView {

	String defaultString = ""; 
	String mov = "-";

	// 1회 끝난 int배열 값을 "-"개수로 변환하는 메소드
	public int[] OutputView(int[] in) {
		for (int i = 0; i < in.length; i++) { // 배열의 개수만큼
			for (int j = 1; j <= in[i]; j++) { // 배열의 값 만큼
				defaultString += mov;
			}
			System.out.println(defaultString); // "-" 출력
			defaultString = ""; // 다음 계산을 위한 초기화
		}		
		return in;
	}
}
