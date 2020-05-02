# Projet DevOps - M1 Informatique 2019-2020
## Une bibliothèque d’analyse de données en Java


[![codecov](https://codecov.io/gh/ViroFire/ProjetDevops/branch/master/graph/badge.svg?token=Q7TUFZY53B)](https://codecov.io/gh/ViroFire/ProjetDevops)

![build](https://travis-ci.com/ViroFire/ProjetDevops.svg?token=FXtNVbUpNMLYMFx4sVxD&branch=master)

La version finale est sur la branche master.

### Fonctionnalités fournies
**Dataframe**
- Création d'un dataframe sous forme de tableau de String
- Création d'un dataframe à partir d'un fichier .csv
- Affichage d'un dataframe
- Affichage par colonne d'un dataframe
- Affichage des premières lignes d'un dataframe
- Affichage des dernières ligne d'un dataframe

### Choix d'outils
- Apache Maven : outil le plus appronfondi en cours, pouvoir définir un format par défaut du projet, automatisation de l'intégration continue (en lien avec Travis CI). Utilisation de joCoCo et codecov pour la couverture de code avec ajout du badge de couverture de code sur le README.md. Nous avons aussi utilisé le plugin surefire pour la génération de rapports.
- Travis CI : pouvoir gérer l'intégration continue depuis GitHub (lieu du dépôt) avec ajout du badge "build" sur le README.md
- JUnit : automatisation des tests comme vu en cours et TP (inclus à Maven)

### Images DockerHub
Non implémenté.

### Feedback
- Maven est un outil qui a l'air très complet et pratique, qui peut finalement résoudre nombre de problèmes relativement "facilement". Malgré tout l'outil est assez compliqué à configurer, notamment le fichier pom.xml, même avec le cours et la documentation officielle en ligne. Nous pensons que c'est un outil dont l'apprentissage mérite d'être approfondi car vraiment nécessaire lors de construction de projets. Nous le réutiliserons sûrement dans les autres projets que nous aurons à faire à l'avenir.
- JUnit est un outil que nous avions trouvé très pratique en TP et il l'a également énormément été sur ce projet.
- Nous n'avons pas implémenté énormément de fonctionnalités (temps, problèmes divers) mais nous avons voulu nous concentrer sur celles que nous avons faites pour que les tests implémentés les couvrent le plus possible.
- Travis CI est un outil très pratique et agréable à utiliser qui nous a beaucoup aidé pour détecter les erreurs de build.
- Nous n'avons pas pu gérer toute la partie Docker par rapport au temps et le fait qu'on nous ne pouvons pas utiliser l'outil en lui-même sur nos ordinateurs personnels.

### Pour aller plus loin
Nous avons implémenté de quoi mettre la javadoc et la déployer mais à priori pas correctement.
Nous aurions beaucoup aimé faire ce projet dans les conditions normales (beaucoup de soucis de compatibilités ou de non supporté sur nos PCs). Nous l'avons trouvé vraiment intéressant et très instructif notamment grâce aux divers outils utilisés en parallèle sur le même projet. Nous aurions pu implémenter plus de fonctionnalités et donc plus de tests avec un peu plus de temps (le délai était très bien, c'est surtout la situation actuelle qui a fait que).
C'est un projet qui va nous permettre d'améliorer la qualité de tous les projets suivants dans d'autres UEs.
