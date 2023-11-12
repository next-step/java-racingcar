## 미션 목표

핵심 비지니스 로직을 가지는 객체를 domain 패키지, UI 관련한 객체를 view 패키지에 구현한다.

1. 핵심 비지니스 로직 > Domain 패키지
2. UI 객체 > View 형태로
   MVC 패턴 기반으로 리팩토링해 view 패키지의 객체가 domain 패키지 객체에 의존할 수 있지만, domain 패키지의 객체는 view 패키지 객체에 의존하지 않도록 구현한다.

- [] 비즈니스로직 Car, CarRacing 두개
- [] UI 로직 InputView, OutputView
    - [] 현재 형태 CarRacing이 InputView에 의존하는 형태. 반대로 구현
      테스트 가능한 부분과 테스트하기 힘든 부분을 분리해 테스트 가능한 부분에 대해서만 단위 테스트를 진행한다.
- [] 랜덤값 테스트한 부분을 생성자 형태로 리펙토링