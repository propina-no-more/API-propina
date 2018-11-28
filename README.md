# Bem-vindo ao WebServer Propina no more!

Este web services tem o intuído de gerar  uma **API RestFul** para o site www.proprinanomore.com.br.

# Documentação
### Formato de requisições
Para listar todas as denuncias:

> [GET] http://13.82.130.246:9005/api/denuncia/

Para listar todas as denuncias por órgão:
> [GET] http://13.82.130.246:9005/api/denuncia/?nome=Nome_do_orgao

Inserir nova denuncia p:
> [GET] http://13.82.130.246:9005/api/denuncia/?nome=Nome_do_orgao

Para remover uma denuncia:
> [DELETE] http://13.82.130.246:9005/api/denuncia/

```json
{
	"codDenuncia" : "codigo_da_denuncia"
}
```
