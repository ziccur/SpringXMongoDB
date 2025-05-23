### Treball fet per: Yeray Reyes ( https://github.com/ziccur/ )

# Millores i preguntes de reflexió

## Afegiu un endpoint que cerqui per un camp de tipus String on feu servir regex. Afegiu el
que calgui al servei, repositori, etc.

En el meu cas he afegit un endpoint que busca per el nom de l'animal amb regex. Per fer-ho he afegit un nou mètode a l'interface `AnimalRepos`. També l'he afegit al seu correspondent servei: `AnimalService`. A més, he afegit un nou endpoint al controlador `AnimalController` que permet fer cerques per nom d'animal amb regex, aquest es diu `searchAnimalsByName` i al swagger apareix com `/api/v1/animals/search`.

## Què caracteritza una api reactiva com aquesta i què la fa diferent d’una api síncrona amb
MVC com les treballades anteriorment?

La diferencia és que una API reactiva gestiona peticions de forma asíncrona i no bloquejant amb Flux/Mono, permetent alta concurrència. Una API síncrona bloqueja fils per cada petició, limitant recursos i rendiment. Com es va explicar a classe amb les asyncrones si tenim molts clients alhora podem donar serveis a tots ells alhora.

## Què signifiquen Mono i Flux? Per a què penseu que serveixen i per què són útils en aquest
tipus de programació?

Com s'explica en el PDF Mono es una classe que ens permet guardar valors, el problema es que només podem guardar 0 o 1 de la classe que li hem indicat. Per aixo tenim Flux que ens permet guardar més d'un de la classe que l'indiquem. Exemples que he usat a la classe `AnimalController`: 
    -   Mono: per getters d'un unic registe com `/api/v1/animals/{id}`
    -   Flux: per getters amb múltiples registre com: `/api/v1/animals/all`

## Què és record? Un record utilitza getters i setters? Justifiqueu la resposta

Un record és una classe Java immutable que defineix dades de forma concisa. No utilitza setters perquè és immutable. Els getters són implicits, però sense el prefix "get". Això garanteix que les dades no es modifiquin després de la creació. Així doncs un recod no té ni usa setters i no cal que generis getters ja que aquests son implicits i els pots consultar de manera predeterminada.

# PROVES AMB SWAGGER

## POST: /api/v1/animals/save

El save demana les següents dades: 
```
    {
        "id": "1",
        "nom": "PROVA 1",
        "edat": 1
    }
```

Imatges de swagger
![Exemple de petició POST a Swagger](./media/POST1.png)
![Exemple de petició POST a Swagger](./media/POST2.png)

Imatge de Terminal
![Exemple de petició POST a Swagger](./media/POST2.png)
