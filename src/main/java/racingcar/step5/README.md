**step5. 자동차 경주(리팩토링)**
-
**- 요구사항**
1. MVC 패턴 적용
2. 테스트 가능한 부분과 테스트하기 힘든 부분을 분리
3. 모든 원시값과 문자열을 포장
4. 일급 컬렉션 사용
5. code convention, format, naming 

**- TODO 리스트**
1. ~~MovingStrategy domain 패키지로 변경, 인터페이스 이름 변경~~
2. ~~Name 클래스 분리 및 테스트 작성~~
3. ~~Position 클래스 분리 및 테스트 작성~~ 
4. ~~code convention, format, naming~~
5. ~~Message를 클래스로 분리 -> 메시지 중복제거~~
6. ~~toString 오버라이딩 -> 출력 뷰 수정~~

**- 기능 목록**
1. Position 클래스
2. Name 클래스
3. Message 클래스
    - ErrorMessage : 에로관련 메시지 작성
    - ViewMessage : 출력관련 메시지 작성

**- 피드백 반영**
1. toString()은 보통 로깅을 위한 용도로 사용됩니다:)
   -> toString() 삭제 후 ResultView에 반영
2. 람다식 이렇게 표현하면 어떨까요?
   -> 람다식 변경 joining!!!!