# Request-Acknowledge-Callback

Le but  est d’implémenter le pattern: Request/Acknowledge/Callback
Nous supposons que le client fait appel au web service pour une requête qui demande un très long calcul.

Etapes:

La classe ClientMain qui :
o Envoie une requête GET au service avec l’url :
  ➢ Domain/Application/service/calcule
o Dans le Header «Location » de la requête le client met l’URL du service qui recevra
  la réponse.
  
Le web service « Service » qui :
o Reçoit la requête de la part du client et retourne un status « 303», ensuite il lance
  un Thread Callback en lui passant l’url (se trouvant dans le header « Location ») du service qui recevra la réponse :
  ➢ new CallBack(url).start();
La classe Callback qui :
o Envoie un POST au web service ServiceCallBack lorsque la réponse est prête .
  ➢ Pour simplifier la payload du POST contiendra le message «la réponse envoyée» que le ServiceCallback affichera dans la console.
