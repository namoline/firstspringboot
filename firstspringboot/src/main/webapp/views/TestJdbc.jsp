<html>
    <head>
        <title>Your first Spring application</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    </head>
    <body>
        
        <form action="/testDatabase" method="GET" id="nameForm">
            <div>
                <label for="nameField">Test Acces base de données</label>
                <input type="hidden" id="id" name="id" value="1">
                <button>envoyer</button>
                
                
            </div>
            <div>
				<label for="nameField">Resultat:</label>
				${ resultat }
             </div>
        </form>
         <form action="/testDatabase" method="GET" id="nameForm">
            <div>
                <label for="nameField">Test d'interrogation de table</label>
                <input type="hidden" id="id" name="id" value="2">
                <button>envoyer</button>
                
                
            </div>
            <div>
				<label for="nameField">Resultat:</label>
				${ resultat2 }
             </div>
        </form>
    </body>
</html>