As orientações de manuseio e instalação estão definidas no arquivo Orientações de Manuseio e Instalação.docx da pasta /code

#Propina no more com Spring Boot, MySQL, JPA, Hibernate Rest API

Desenvolver uma API Restful para realizar denuncia e consulta utilizando Spring Boot, Mysql, JPA and Hibernate.

## Requisitos

1. Java - 1.8.x

2. Maven - 3.x.x

3. Mysql - 5.x.x

## Etapas para começa

**1. Clone o projeto**

```bash
git clone https://github.com/propina-no-more/API-propina.git
```

**2. Criar banco de dados Mysql**
```bash
create database propinanomore
```

**3. Inserir usuário e senha de instalação do mysql**

+ abrir `src/main/resources/application.properties`

+ inserir `spring.datasource.username` e `spring.datasource.password`.

**4. Exculta através do maven**

```bash
mvn package
java -jar target/propina-no-more-1.0.0.jar
```


O aplicativo começará a ser executado em <http://localhost:9000>.

## Caminhos Rest APIs

O aplicativo define as seguintes APIs de CRUD.

	GET /api/v1/denuncia
	
	GET /api/v1/denuncia/arquivo/
	
	GET /api/v1/denuncia/arquivo/{codProva}
    
	GET /api/v1/denuncia/{nomeOrgao}
    
	PUT /api/v1/denuncia/
 
 POST /api/v1/denuncia/arquivo
 
 ```json
 {
 	"arquivo":"seu arquivo"
 }
 
 ```
 
 POST /api/v1/denuncia

```json
{
	"ano": 2018,
	"cpf": null,
	"nome": "Fernando Gurgel",
	"onde": "lugar",
	"oque": "descrição",
	"quando": "28/11/2018",
	"sigilo": "N",
	"telefone": "92 3615-5757",
	"edital": {
		"codEdital": 1,
		"ganhador": "LIRA SERVICOS E LAVANDERIA LTDA - ME (19.870.403/0001-10)",
		"objetoLicitado": "Ser.de Manut. de Percianas - Casa Civil",
		"referencia": "RDL 004/17",
		"status": "Homologado Total",
		"orgao_id": {
			"codOrgao": 1,
			"nome": "SECRETARIA DE ESTADO DA CASA CIVIL",
			"sigla": "CASA CIVIL"
		}
	},
	"orgao": {
		"codOrgao": 1,
		"nome": "SECRETARIA DE ESTADO DA CASA CIVIL",
		"sigla": "CASA CIVIL"
	},
	"provas": [
		{
			"codProva": 1,
			"caminhaArquivo": "/var/WWW/html/img/",
			"tipoProva": "img"
		}
	]
}
```
    
   DELETE /api/v1/denuncia/{codDenuncia}
    
```json
{
	"codDenuncia" : "codigo_da_denuncia"
}
```

You can test them using postman or any other rest client.
