
# Public Transport Management




# Proje Hakkında 

MySQL kullanılarak operasyonlar gerçekleştirilmiştir. Spring Security ile birlikte kullanıcı olarak kayıt olarak gerekli yetkiler alındığı takdirde kullanılabilir. 



## Kullanılan Teknolojiler

- Spring
- Spring Security 
- Hibernate
- MySQL
- Jpa


  
## API Kullanımı

### Bazı API Kullanımları

#### Tüm kullanıcıları listeleme

```http
  POST /signin
```

| Parametre | Tip     | Açıklama                |
| :-------- | :------- | :------------------------- |
| `application/json` | `LoginDto` | **Email ve password bilgileri alınır.**. 


#### Kullanıcı oluşturma
```http
  POST /signup
```

| Parametre | Tip     | Açıklama                       |
| :-------- | :------- | :-------------------------------- |
| `gerekli kullanıcı bilgileri`      | `SignUpDto` | **Kullanıcı kayıt için gerekli bilgiler alınır.**.  |


#### Kullanıcı id 

```http
  GET /users
```

| Parametre | Tip     | Açıklama                       |
| :-------- | :------- | :-------------------------------- |
| `application/json`      | `LoginDto` | **Veritabanı tarafında kayıtlı tüm kullanıcılar alınır.**. |


#### Tüm ilanları listeleme

```http
  GET /vehicles
```

| Parametre | Tip     | Açıklama                       |
| :-------- | :------- | :-------------------------------- |
| `application/json`      | `VehicleDto` | **Veritabanı tarafında kayıtlı tüm araçlar alınır.** |

```http
  GET /stations
```

| Parametre | Tip     | Açıklama                       |
| :-------- | :------- | :-------------------------------- |
| `application/json`      | `StationDto` | **Veritabanı tarafında kayıtlı tüm istasyonlar alınır.** |




  