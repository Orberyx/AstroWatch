# AstroWatch

Nada para ver por enquanto ;)

## TODO

- hierarquia de arquivos
```
AstroWatch/ (esse repositório)
├── README.md
├── source/ (código fonte)
├── sql/ (modelo de banco de dados)
│   ├── DER
│   ├── DL
│   └── Scripts SQL
├── design/ (design do projeto)
├── icons/ (icones da interface)
├── utils/ (materiais auxiliares de desenvolvimento)
├── uml/ (diagramas uml)
```
- kanban do projeto

## Responsabilidades (esborço)

```
src/main/java/io/github/orberyx/astrowatch/
│
├── App.java                          Todos (ressalvas)
│
├── model/
│   └── Asteroid.java                 Renan
│
├── nasa/
│   ├── NasaApiClient.java            Wendel
│   └── NasaAsteroidParser.java       Wendel
│
├── service/
│   └── AsteroidService.java          Wendel
│
├── filter/
│   └── AsteroidFilter.java           Adriel
│
├── repository/
│   ├── AsteroidRepository.java       Renan
│   └── UserRepository.java           Renan
│
├── auth/
│   └── AuthService.java              Mayrllon
│
└── controller/
    └── AsteroidController.java       Nívea
```