# Simply

Simply est un système de mise à jour pour application Java

  - Configurable
  - Choix de l'interface
  - Rapide

### Utiliser le code

Simply a besoin de Java 7+ et utilise Maven.

Télécharger ``BreakGo-updater`` et ouvrez votre IDE sur le dossier.

```sh
$ git clone https://github.com/Asuniia/BreakGo-updater.git
$ cd BreakGo-updater
```

### Déployer les mise à jours

Un hebergement web est requis.

```sh
Dans le ``/root`` de votre hebergement créez deux dossier se nommant ``[Nom_de_app_du_config.json]`` et de ``[Nom_de_app_du_config.json]_versions``.

Mettez dans le dossier ``[Nom_de_app_du_config.json]`` un fichier qui s'appelle ``Versions.info`` et mettez dedans la version de l'application. *(ex: 0.3)*
```


### Librairies utilisé

Les librairie utilisé sont pour la plupart open source. Elle sont totalement gratuite !

| Nom | Lien |
| ------ | ------ |
| JavaFX | https://openjfx.io/ |
| Apache | https://commons.apache.org/ |
| Gson | https://github.com/google/gson |
