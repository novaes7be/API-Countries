# 🌍 API Countries

Projeto Java para consumo da API pública [RestCountries](https://restcountries.com/), desenvolvido como estudo de integração com APIs externas usando Java puro (sem Spring Boot).

---

##  Tecnologias

- Java 11+
- [RestCountries API v3.1](https://restcountries.com/) — sem necessidade de autenticação
- [Gson 2.10.1](https://github.com/google/gson) — parsing de JSON
- Maven — gerenciamento de dependências

---

##  Estrutura do Projeto

```
src/main/java/
├── Main.java           # Ponto de entrada
├── ClientHttp.java     # Requisições HTTP
├── CountryParser.java  # Parsing e exibição dos dados
└── MenuService.java    # Menu interativo
```

---

##  Funcionalidades

| Opção | Descrição |
|---|---|
| 1 | Listar todos os países |
| 2 | Buscar país por nome |
| 3 | Buscar países por região |
| 4 | Buscar países por idioma |
| 0 | Sair |

---

##  Como rodar

**1. Clone o repositório**
```bash
git clone https://github.com/novaes7be/API-Countries.git
cd API-Countries
```

**2. Compile com Maven**
```bash
mvn compile
```

**3. Execute**
```bash
mvn exec:java -Dexec.mainClass="Main"
```

---

##  Aprendizados

- Uso de `HttpClient`, `HttpRequest` e `HttpResponse` do Java 11
- Parsing de JSON com Gson (`JsonArray`, `JsonObject`, `JsonParser`)
- Organização de projeto em camadas (HTTP, Parser, Menu)
- Consumo de API REST pública sem autenticação
