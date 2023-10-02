- COMANDOS DE SQL IMPORTANTES:
   SELECT: extrae datos;
   
   UPDATE: actualiza datos (según le asignemos);
   
   DELETE: elimina datos;
   
   INSERT INTO: inserta datos;
   
   CREATE DATABASE: crea una base de datos;
   
   ALTER DATABASE: modifica una base de datos;
   
   CREATE TABLE: crea una tabla;
   
   ALTER TABLE: modifica una tabla existente;
   
   DROP TABLE: elimina una tabla;
   
   CREATE INDEX: crea una clave de busqueda;

   ---> ¿Qué significa indexar?: Indexar significa crear una referencia (como un puntero) que permite una busqueda eficiente de una tabla;
   ---> ¿Qué significa clave de busqueda?: Una clave de busqueda es una columna o columnas que se indexan para conseguir busquedas eficientes de la tabla;
   
   DROP INDEX: elimina una clave de busqueda;

   ---> ¿Se usan las comillas simples o las dobles?: Es recomendable usar las simples ('') siempre que vayas a crear una cadena de caracteres, ya que son compatibles con todas las bases de datos,
        en cambio las comillas dobles no son siempre compatibles. Es recomendable usar las dobles cuando quieras tener algo así ==> SELECT "It's a string" FROM tabla;

<------------------------------------------------------------------------------------------------------------->

   - CONSULTA SELECT: 
   
   select * from table;
   select column2, column1 from table1;

   - CONSULTA SELECT DISTINCT: Extrae todos los datos unicos de una columna o columnas;

   select distinct column1 from table1;

   - CONSULTA WHERE: Condición para filtrar registros;

   select column1, column2... from table1 where condition;

   select * from Customers where Country = "México";

   - OPERADORES INTERESANTES:

   Algunos son: between (entre un rango), like (buscar un patrón), in (especificar varios valores en una columna) => ejemplo de in: select * from Customers where City in ('Paris', 'Mexico',...);
   Recuerda que son operadores asi que actuan como tal, otros más típicos son por ejemplo: =, <, <=, >, >=...

   Otros operadores MUY USADOS en where son AND, OR Y NOT.
   Sintaxis de AND: select column1, column2,... from table1 where condition1 and condition2...;

   Sintaxis de OR: select column1, column2,... from table1 where condition1 or condition2...;

   Sintaxis de NOT: select column1, column2,... from table1 where not condition1;

   - EJEMPLOS ESPECÍFICOS:
     
   select * from Customers where Country = 'Germany' and (City = 'Berlin' or City = 'Stuttgart');

   select * from Customers where not Country = 'Germany' and not Country = 'USA';

   - CONSULTA ORDER BY: Ordena de mayor a menor una columna (se puede especificar con DESC O ASC);

   - CONSULTA INSERT INTO: Para insertar nuevos valores a la tabla;

     Primera forma: insert into tabla1 (column1, column2, column3...) values (value1, value2, value3...);
     
     Segunda forma: insert into tabla1 values (value1, value2...);

   -> COSA EXTRA: Puedes decidir en que columnas quieres meter datos, no tienen porque ser todas;

   - VALORES NULL:

     A la hora de identificar si alguna columna tiene null, tenemos que usar operadores especiales:
     select * from Customers where Country is null

<------------------------------------------------------------------------------------------------------------->

   - ¿CÓMO FUNCIONA LOAD DATA INFILE EN MYSQL SHELL?:

     A ver, load data infile sigue la siguiente estructura:
     
     LOAD DATA INFILE 'ruta/al/archivo.csv'
     INTO TABLE nombre_de_la_tabla
     FIELDS TERMINATED BY ','
     LINES TERMINATED BY '\n'
     IGNORE 1 LINES;

     Expliquemos bien que hace cada cosa.

     -> LOAD DATA INFILE 'ruta/al/archivo.csv': Proporcionar la ruta donde se encuentra el archivo csv
     -> INTO TABLE nombre_de_la_tabla: Asignar la tabla donde deseas introducir los datos
     -> FIELDS TERMINATED BY ',': Especifica el delimitador que se usa en el csv. Lo habitual es encontrar ',' pero también se usa ';'
     -> LINES TERMINATED BY '\n': Indica que por cada linea escrita hay un salto de linea (se usa el caracter de salto de linea \n generalmente)
     -> IGNORE 1 LINES: Si deseas ignorar una linea de tu csv porque esta la sección de columnas puedes hacerlo

   - ERRORES COMUNES:

       Qué salte este error: The MySQL server is running with the --secure-file-priv option so it cannot execute this statement

     - SOLUCIÓN: Acceder a las variables de configuración de mySQL => show variables like 'secure_file_priv' => si te sale 'empty set' =>
       => grant file on *.* to 'root'@'localhost' (no hace falta poner 3306 ya que es el puerto predeterminado) => ya te sale => metes
       el archivo csv a la ubicación => pruebas load data;

     - O con show variables like 'local_infile' lo pones ON y pruebas (recuerda reiniciar el servidor de mySQL en el panel de control);

   
   

   


