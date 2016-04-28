# TAGL
TAGL projet


Le projet est organisé en deux parties : <br/>
                                        - La Base de donnée pour la manipulation des données dans la ConcurrentHashMap <br/>
                                        - Les classes pour la connexion entre le client et le serveur
                                        
Le client/serveur :<br/>
                  - La parallélisation :Le serveur peut gérer plusieurs clients (10) simultanément grâce à un pool de threads( class       "ServerThreadPooled" ). <br/>
                  - Les écritures dans la base de donnée sont bien gérées par une structure de type ConcurrentHashMap.<br/>
                  - Le serveur : La base de donnée contenant les relations clée/valeurs peut-être accédée à distance grâce à un schema client/serveur (les classes sont le "Client", le "launchServer" et le "WorkerRunnable").<br/>
                  
La Base de donnée :<br/>
                  - La base de donnée est initialisée avec un nombre d'objets qu'elle peut contenir au maximum( on a pris le nombre d'objets plutôt que la mémoire allouée car il est difficile en java de récupérer la taille d'un objet).<br/>
                  - Avec la méthode "getTaille_courante" on peut accéder au nombre d'objets contenus dans la base de donnée.<br/>
                  - On peut manipuler des objets dans la base de donnée avec "getObject", "suppObject" et "getObject" . Si la taille de la ConcurrentHashMap dépasse la taille maximum on enlève le dernier objet de la ConcurrentHashMap. Cependant, on ne peut le faire qu'une fois, car il faudrait alors trouver à chaque fois le dernier objet mis dans la hashmap et celà nuirait aux performances.
                  
Les Tests :<br/>
                  - Les deux premiers tests sont sur une utilisation basique des méthodes getObject,suppObject ,et addObject. <br/>
                  - Le troisième test mélange l'utilisation de ses méthodes, et le le quatrième vérifie le cas extrême quand la hashMap a atteind sa taille au maximum.<br/>
                  - Pour finir nous avons effectués des tests sur des entiers aléatoires avec une taille inférieure ou égale à 300 .<br/>
                      
En résumé, les fonctionnalitées implémentées sont : Parallèlisation, Serveur, Cache LRU.
