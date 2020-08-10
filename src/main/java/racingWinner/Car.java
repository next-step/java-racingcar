package racingWinner;


public class Car {

	private final static int STRING_MAX_LENGTH = 5;
	private final static int RUN = 4;
	
	private String name;
	private int location = 0;
	
	public Car(String name) {
		//객체가 스스로 판단하게 변경. 5자 초과시 IllegalArgumentException
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

	//최대값과 location이 같다면 이름 return
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
	
	//차 객체의 이동거리 출력
	public String printCar() {
		String value = this.name + " : ";
		for(int i = 0; i < location; i++) {
			value = value + "-";
		}
		return value;
	}

}
