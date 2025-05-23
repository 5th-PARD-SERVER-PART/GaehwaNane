# E소원과 I들의 숏커톤

### CRUD

- User

| CRUD | 내용 |
|--|--|
| C | 유저 생성 |
| D | 유저 삭제 |

- Emotion

| CRUD | 내용 |
|------|--|
| C    | 유저에 따른 감정 내역 생성 (ID, content, createdDate)|
| R | 현재 유저가 작성한 감정 내역 조회 |
| U | 유저가 적은 감정 내역 수정 |
| D | 유저가 적은 감정 내역 삭제 |

### ERD

<img src="images/ERD.png">

### API 명세서

### User

[POST]

URL = `/user`

| **Key** | **타입** | **설명** |
| --- | --- | --- |
| `name` | String | 사용자 이름 (필수) |

Request

```json
{
	"name": "홍길동"
}
```

| **Key** | **타입** | **설명** |
| --- | --- | --- |
| `ID` | Long | 자동 생성 userID |
| `name` | String | 사용자 이름 |

Response

```json
{
	"ID": 1,
	"name": "홍길동"
}
```

[DELETE]

URL = `/user/{userId}`

| **Key** | **타입** | **설명** |
| --- | --- | --- |
| `userId` | Long | 사용자 ID (필수) |

Request

```json
{
	"name": "홍길동"
}

```

Response

```json
# 200 OK
```

### Emotion

[POST]

URL = `/emotion`

| **Key** | **타입** | **설명** |
| --- | --- | --- |
| `userId` | Long | 사용자 ID (필수) |
| `content` | String | 감정 내용 |

Request

```json
{
	"userId": 1,
	"content": "아 진짜 상사 자식 자기가 뭐가 잘났다고 하는 일마다 이래라 저래라야 진짜 없애버릴수도 없고"
}
```

| **Key** | **타입** | **설명** |
| --- | --- | --- |
| `ID` | Long | 자동 생성 emotionID |
| `userId` | Long | 사용자 ID |
| `content` | String | 감정 내용 |
| `createdDate` | LocalDate | 작성 날짜 |

Response

```json
{
	"ID": 1,
	"userID": 1,
	"content": "아 진짜 상사 자식 자기가 뭐가 잘났다고 하는 일마다 이래라 저래라야 진짜 없애버릴수도 없고"
	"createdDate": "2025-05-24"
}
```

[GET]

URL = `/emtion/{userId}`

| **Key** | **타입** | **설명** |
| --- | --- | --- |
| userId | Long | 사용자 이름 (필수) |

Request

```json
{
	"userId": 1
}

```

Response

```json
{
	"id": 1,
	"name": "홍길동"
}
```

[PATCH]

URL = `/emotion/{emotionId}`

| **Key**     | **타입** | **설명** |
|-------------| --- | --- |
| `emotionId` | Long | 감정 ID (필수) |

Request

```json
{
	"content": "아 살기가 귀찮다."
}
```

| **Key** | **타입** | **설명** |
| --- | --- | --- |
| `ID` | Long | 자동 생성 userID |
| `name` | String | 사용자 이름 |

Response

```json
{
	"ID": 1,
	"userID": 1,
	"content": "아 살기가 귀찮다."
	"createdDate": "2025-05-24"
}
```

[DELETE]

URL = `/emotion/{emotionId}`

| **Key** | **타입** | **설명** |
| --- | --- | --- |
| `emotionId` | Long | 감정 ID (필수) |

Request

```json
{
	"emotionId": 1
}

```

Response

```json
# 200 OK
```

### 클백 연결표

