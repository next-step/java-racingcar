/*
 * 클래스 이름
 * 이름
 * 버전 정보
 * 1.0
 * 날짜
 * 2020.11.15
 * 저작권 주의
 */

package model;

import java.util.Objects;

public class Name {
    private static final int MAX_LENGTH = 5;
    private String name;

    public Name (String name) {
        checkName(name.trim());
        this.name = name.trim();
    }

    private void checkName (String name) {
        isNameNull(name);
        isNameBlank(name);
        isNameOverMaxLength(name);
    }

    private void isNameOverMaxLength (String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 5자를 넘을 수 없습니다.");
        }
    }

    private void isNameBlank (String name) {
        if ("".equals(name.trim())) {
            throw new IllegalArgumentException("빈값을 입력할 수 없습니다.");
        }
    }

    private void isNameNull (String name) {
        if (name == null) {
            throw new IllegalArgumentException("null값을 입력할 수 없습니다.");
        }
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode () {
        return Objects.hash(name);
    }

    public void print () {
        System.out.print(name);
    }
}
