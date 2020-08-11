package racingWinner;


public class Car {

	private final static int STRING_MAX_LENGTH = 5;
	private final static int RUN = 4;
	private String name;
	private int location = 0;
	
	public Car(String name) {
		//객체가 스스로 판단하게 변경
		if(name.length() > STRING_MAX_LENGTH) {
			throw new IllegalArgumentException("차 이름은 5자를 초과할 수 없습니다.");
		}
		this.name = name;
	}
	
	//카 객체 스스로 책임 runOrStopCondition
	public void go(int condition) {
		if(RUN <= condition) {
			++this.location;
		}
	}

	public String winner(int location) {
		if(location == this.location) {
			return name;
		}
		return null;
	}
	
	public String getName() {
		return name;
	}

	public int getLocation() {
		return location;
	}
	
	

}
