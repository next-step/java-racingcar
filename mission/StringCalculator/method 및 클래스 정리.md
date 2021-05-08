StringCalculator
========================
method 및 클래스 정리
--------------------------
#### `Scanner`
- 객체를 생성하고 읽어들이는 기능
- 실행창에서 값을 입력하고 출력 방식
- java.util 패키지의 Scanner 클래스
- `nextLine` : 입력받은 문자열을 저장
  
##### 실행 코드
```java
// input 출력
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("input 값을 입력하세요 : ");
    String inputValue = scanner.nextLine();
    System.out.println(inputValue);
}
```
##### 결과
![scanner](../../img/scanner.PNG)
##### scanner 입출력 단위 테스트
- 사용자 입출력(UI)과 관련된 테스트는 가능하지만 구현이 어려운 부분 
- 테스트 코드는 컴퓨터가 실행하는 코드라 사용자의 입력이 필요한 스캐너를 만나면 존재하지도 않는 사용자의 입력을 계속 기다리면서 에러발생



