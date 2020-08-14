package racingWinner;


public class CarFactory {

	private final static int STRING_MAX_LENGTH = 5;
	private final static int RUN = 4;
	private String name;
	private int location = 0;
	
	public CarFactory(String name) {
		if(name.length() > STRING_MAX_LENGTH) {
			throw new IllegalArgumentException("차 이름은 5자를 초과할 수 없습니다.");
		}
		this.name = name;
	}
	
	public void go(int condition) {
		if(RUN <= condition) {
			++this.location;
		}
	}

	public String winner(int location) {
		if(location == this.location) {
			return name;
		}
		return "";
	}
	
	public String getName() {
		return name;
	}

	public int getLocation() {
		return location;
	}
}
