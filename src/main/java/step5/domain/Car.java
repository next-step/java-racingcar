package step5.domain;

public class Car {
	private final static int STRING_MAX_LENGTH = 5;
	private final static int RUN = 4;
	private String name;
	private int location = 0;
	
	public Car(String name) {
		if(name.length() > STRING_MAX_LENGTH) {
			throw new IllegalArgumentException("차 이름은 " + STRING_MAX_LENGTH + "자를 초과할 수 없습니다.");
		}
		this.name = name;
	}
	
	public Car(String name, int location) {
		new Car(name);
		this.location = location;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + location;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (location != other.location)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
