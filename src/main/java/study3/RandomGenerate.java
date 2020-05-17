package study3;

import java.util.Random;

/*
 * random값 생성하는 클래스
 * author : choi
 */
public class RandomGenerate {

	private static int randomrange = 10;

	public int RandomGenerate() {
		Random ran = new Random();
		int a = ran.nextInt(randomrange);
		return a;
	}
}
