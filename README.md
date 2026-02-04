##  API 명세

### Base URL
- `http://localhost:8080`

###  📆 일정 생성
####  Request
- **Method**: `POST`
- **Endpoint**: `/plans`
- **Content-Type**: `application/json`

---

####  Response

##### ▶ 201 Created (생성 성공)
```json
  {
    "id": 4,
    "name": "이짹짹",
    "title": "일본여행",
    "contents": "삐약이랑 휴가",
    "createdAt": "2026-02-04T15:10:22",
    "updatedAt": "2026-02-04T15:10:22"
  }
```

#### ▶ 400 Bad Request (요청 오류) , 500 (서버 내부 오류)
```json
{
  "status": 400,
  "error": "Bad Request",
  "message": "이름은 필수 입력 값 입니다."
}
```
```json
{
  "status": 500,
  "error": "Internal Server Error",
  "message": "요청을 처리하는 중 서버에서 오류가 발생했습니다."
}
```

###  📆 전체 일정 조회
####  Request
- **Method**: `GET`
- **Endpoint**: `/plans`
- **Accept**: `application/json`

---

####  Response

##### ▶ 200 OK (성공)
```json
 [
  {
    "id": 1,
    "name": "김나비",
    "title": "미팅",
    "contents": "거래처 딩동댕이랑 미팅있음",
    "createdAt": "2026-02-04T14:32:18",
    "updatedAt": "2026-02-04T14:32:18"
  },
  {
    "id": 2,
    "name": "김야옹",
    "title": "계모임",
    "contents": "놀이동산 가기로 ㄱㄱ",
    "createdAt": "2026-02-04T15:10:22",
    "updatedAt": "2026-02-04T15:10:22"
  },
  {
    "id": 3,
    "name": "김멍멍",
    "title": "점심약속",
    "contents": "엄마랑 파스타 먹기로 함",
    "createdAt": "2026-02-04T16:01:45",
    "updatedAt": "2026-02-04T16:01:45"
  }
]
```

#### ▶ 500 Internal Server Error (서버 내부 오류)
```json
{
  "status": 500,
  "error": "Internal Server Error",
  "message": "요청을 처리하는 중 서버에서 오류가 발생했습니다."
}
```

###  📆 선택 일정 조회
####  Request
- **Method**: `GET`
- **Endpoint**: `/plans/{planId}`
- **Accept**: `application/json`

---

####  Response

##### ▶ 200 OK (성공)
```json
  {
    "id": 2,
    "name": "김야옹",
    "title": "계모임",
    "contents": "놀이동산 가기로 ㄱㄱ",
    "createdAt": "2026-02-04T15:10:22",
    "updatedAt": "2026-02-04T15:10:22"
  }
```

#### ▶ 500 Internal Server Error (서버 내부 오류), 404 Not Found (리소스 없음)
```json
{
  "status": 404,
  "error": "Not Found",
  "message": "해당 일정이 존재하지 않습니다."
}
```
```json
{
  "status": 500,
  "error": "Internal Server Error",
  "message": "요청을 처리하는 중 서버에서 오류가 발생했습니다."
}
```
###  📆 선택한 일정 수정 
####  Request
- **Method**: `PUT`
- **Endpoint**: `/plans/{planId}`
- **Content-Type**: `application/json`

---

####  Response

##### ▶ 200 OK (성공)
```json
 {
    "id": 2,
    "name": "황생선",
    "title": "계모임",
    "contents": "맛집투어 하기로 ㄱㄱ",
    "createdAt": "2026-02-04T15:10:22",
    "updatedAt": "2026-02-04T15:10:22"
  }
```

#### ▶ 400 Bad Request(요청 오류), 404 Not Found (데이터 없음), 500 Internal Server Error(서버 내부 오류)
```json
{
  "status": 400,
  "error": "Bad Request",
  "message": "이름은 필수 입력 값 입니다."
}
```
```json
{
  "status": 404,
  "error": "Not Found",
  "message": "해당 일정이 존재하지 않습니다."
}
```
```json
{
  "status": 500,
  "error": "Internal Server Error",
  "message": "요청을 처리하는 중 서버에서 오류가 발생했습니다."
}
```
###  📆 선택 일정 삭제
####  Request
- **Method**: `DELETE`
- **Endpoint**: `/plans/{planId}`
- **Content-Type**: `application/json`

---

####  Response

##### ▶ 204 No Content (삭제 성공)
```json

```

#### ▶ 404 Not Found (데이터 없음) , 500 Internal Server(서버 내부 오류)
```json
{
  "status": 404,
  "error": "Not Found",
  "message": "해당 일정이 존재하지 않습니다."
}
```
```json
{
  "status": 500,
  "error": "Internal Server Error",
  "message": "요청을 처리하는 중 서버에서 오류가 발생했습니다."
}
```