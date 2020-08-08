package step4.dto;

public class Car {
    private int position;
    private String entryName;

    private final String NAME_TAG_SEPERATOR_SEMICOLLON = ":";
    private final String NAME_TAG_EMTPY_SPACE = "      ";

    private Car(String entryName, int position) {
        this.entryName = entryName;
        this.position = position;
    }

    public static Car participateRacing(String entryName, int position){
        return new Car(entryName, position);
    }

    public void movePosition() {
        position++;
    }

    public int nowPosition() {
        return position;
    }

    public String getEntryNameTag() {
        return makeNameTag();
    }

    private String makeNameTag() {
        StringBuilder nameTag = new StringBuilder();
        int length = entryName.length();

        String newPrefix = NAME_TAG_EMTPY_SPACE.substring(length);
        nameTag.append(entryName).append(newPrefix);
        nameTag.append(NAME_TAG_SEPERATOR_SEMICOLLON);

        return nameTag.toString();
    }
}
