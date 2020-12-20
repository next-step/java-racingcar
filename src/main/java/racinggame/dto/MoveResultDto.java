package racinggame.dto;

public class MoveResultDto {
	private String name;
	private int position;

	public MoveResultDto(String name, int position) {
		this.name = name;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public boolean isEqualPosition(int position) {
		return this.position == position;
	}
}
