# Bem-vindo ao WebServer Propina no more!

Este WebServer tem o intuído de gerar  uma **API RestFul** para o site www.proprinanomore.com.br.

# Documentação
### Formato de requisições
Para listar todas as denuncias:
> http://13.82.130.246:9005/api/denuncia/denunciadosTodos

Para listar todas as denuncias por órgão:
> http://13.82.130.246:9005/api/denuncia/buscarPorOrgao?nome=Nome_do_orgao

Para remover uma denuncia:
> http://13.82.130.246:9005/api/denuncia/remover

```json
	{
		 "codDenuncia" = "codigo_da_denuncia"
	}
```