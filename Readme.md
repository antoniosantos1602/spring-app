spring-app % docker run --name mysql-spring \
-e MYSQL_ROOT_PASSWORD=dbpassword101 \
-e MYSQL_DATABASE=userdb \
-p 3306:3306 \
-v $(pwd)/init.sql:/docker-entrypoint-initdb.d/init.sql \
-d mysql:8

docker ps -a

docker exec -it mysql-spring mysql -u root -p

SHOW DATABASES;

controllers → recebem pedidos HTTP
services    → lógica da aplicação
repositories → comunicação com a base de dados
entities     → tabelas/objetos de BD


UserController (REST API)
↓
UserService
↓
UserServiceImpl
↓
UserRepository
↓
MySQL (Docker)


admin101
password101

docker build -t ghcr.io/antoniosantos171/spring-app:1.0.0 .