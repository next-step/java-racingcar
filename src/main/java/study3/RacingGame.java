package study3;

import java.util.Arrays;
import java.util.Scanner;

/*
 *  move로직 클래스
 *  author : choi 
 */
public class RacingGame {

	RandomGenerate rg = new RandomGenerate();
	OutputView rv = new OutputView();

	private int[] carPositions = { 0, 0, 0 }; // 자동차들의 초기 위치

	// move 로직 start
	// 이동한 값을 int 배열에 저장
	public int[] move(int value, int number) {
		for (int j = 0; j < number; j++) { // 시도할 횟수만큼 for문
			for (int i = 0; i < value; i++) { // 자동차개수만큼 for문

				int time = rg.RandomGenerate(); // 랜덤 값 생성
				if (time >= 4) { // 생성한 random값이 4이상일 경우 int[]배열값 +1
					carPositions[i] = carPositions[i] + 1;
				}
			}

			// 시도할 횟수가 1회 끝난 후 저장된 int배열값 출력
			System.out.println(Arrays.toString(carPositions));
			rv.OutputView(carPositions); // 1회 끝난 int배열 값을 "-"갯수으로 변환하는 메소드
			System.out.println(); // 시도한 횟수가 끝날때마다 개행
		}
		return carPositions;
	}
}
