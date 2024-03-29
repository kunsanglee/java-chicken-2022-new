## 메인화면

1 - 주문등록
2 - 결제하기
3 - 프로그램 종료

## 메뉴 정보

[치킨] 1 - 후라이드 : 16000원
[치킨] 2 - 양념치킨 : 16000원
[치킨] 3 - 반반치킨 : 16000원
[치킨] 4 - 통구이 : 16000원
[치킨] 5 - 간장치킨 : 17000원
[치킨] 6 - 순살치킨 : 17000원
[음료] 21 - 콜라 : 1000원
[음료] 22 - 사이다 : 1000원

## 테이블 목록

┏ - ┓┏ - ┓┏ - ┓┏ - ┓┏ - ┓┏ - ┓
| 1 || 2 || 3 || 5 || 6 || 8 |
┗ - ┛┗ - ┛┗ - ┛┗ - ┛┗ - ┛┗ - ┛

## 기능 목록

- 메인 화면에서 주문등록, 결제하기, 프로그램 종료 입력을 받는다.
- 메뉴 기본 정보가 주어지며 **메뉴 번호, 종류, 이름, 가격**을 가진다.
- 테이블 기본 정보가 주어지며 **테이블 번호**를 가진다.
- 한 테이블에서 주문할 수 있는 **한 메뉴의 최대 수량은 99개**이다.
- 주문이 등록된 테이블은 **결제가 이루어지기 전까지 테이블 목록에 별도로 표시**한다.

## 테이블 목록

┏ - ┓┏ - ┓┏ - ┓┏ - ┓┏ - ┓┏ - ┓
| 1 || 2 || 3 || 5 || 6 || 8 |
┗ # ┛┗ - ┛┗ - ┛┗ - ┛┗ - ┛┗ - ┛

- 주문 내역에 대한 계산을 할 때는 **결제 유형에 따라 할인율**이 달라진다.
    - 치킨 종류 메뉴의 수량 합이 **10개가 넘 경우, 10,000원씩 할인**된다.
        - e.g. 10개는 10,000원 할인, 20개는 20,000원 할인
    - **현금 결제는 5%가 할인**되며 **할인된 금액에서 한 번 더 할인**이 가능하다.
- 주문 혹은 결제가 불가능한 경우 그 이유를 보여 주고, 다시 주문 혹은 결제가 가능하도록 해야 한다.
- 최종 결제 금액을 보여준다.

## 기능 목록

- 메인 화면에서 주문등록, 결제하기, 프로그램 종료를 입력 받는다.
    - [x] 입력값이 숫자인지 검증
    - [ ] 입력값이 1,2,3 중 하나인지 검증
- 1번 입력하여 주문등록시 테이블 번호를 입력받는다.
    - [x] 입력값이 숫자인지 검증
    - [ ] 입력한 테이블 번호가 존재하는 테이블 번호인지 검증
    - 주문등록할 메뉴의 번호를 입력받는다.
        - [ ] 입력값이 숫자인지 검증
        - [ ] 입력한 메뉴의 번호가 존재하는 메뉴인지 검증
    - 주문등록할 메뉴의 수량을 입력받는다.
        - [ ] 입력값이 숫자인지 검증
        - [ ] 입력한 메뉴의 수량이 99개 이하인지 검증
        - [ ] 해당 테이블이 주문한 동일한 메뉴의 수량과 이미 주문한 동일한 메뉴의 수량이 99개 이하인지 검증
        - [ ] 테이블 저장소에 해당 테이블이 주문 등록되었다는 것을 저장한다.
- 2번 입력하여 결제시 테이블 번호를 입력받는다.
    - [ ] 입력값이 숫자인지 검증
    - [ ] 입력한 테이블 번호가 존재하는 테이블 번호인지 검증
    - [ ] 해당 테이블 번호를 조회하여 주문한 내역을 조회한다.
    - [ ] {후라이드 1 16000} 형식으로 주문 내역을 출력한다.
    - 해당 테이블의 결제 방식을 선택한다.
        - [ ] 입력값이 숫자인지 검증
        - [ ] 입력값이 1 신용카드, 2 현금 중에 일치하는지 검증
        - [ ] 해당 테이블의 주문내역중 치킨 종류의 총 수량이 10개가 넘는 경우 10,000원씩 할인한다.
        - [ ] 현금 결제시 5% 추가 할인된다.
        - [ ] 주문내역이 없는 테이블을 결제 시도시 에러 반환 후 메인 메뉴로 돌아간다.
- 3번 입력하여 프로그램 종료시
    - [ ] 프로그램을 종료한다.

주문 - 테이블, 주문메뉴, 주문메뉴의 수량
