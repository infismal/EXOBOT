-- database: ../DataBase/EXOBOT.sqlite
/*
-------------------------------------------
(©) 2k24 EPN-FIS, ALL rights reserved.
ismael.heredia@epn.edu.ec
-------------------------------------------
Autor   : ismael.heredia
Fecha   : 15.julio.2k24
Script  : Insertando Catalogo
*/

INSERT INTO CatalogoTipo
    (Nombre,             Descripcion) VALUES
    ('TipoPersona'      ,'tipos sol, meca,...')
   ,('Sexo'             ,'masculino, femenino,...')
   ,('Estado Civil'     ,'sol, viu, cad,...')
   ,('Raza'             ,'negro, blanco,...'); --pilas punto y coma

INSERT INTO Catalogo
    (   IdCatalogoTipo      ,Nombre                 ,Descripcion  ) VALUES
    (    1                  ,'Soldado'              ,'tipos de perso del ejercito') --1 
   ,(    1                  ,'Mecanico'             ,'tipos de perso del ejercito') --2
   ,(    1                  ,'Experto Ing.'         ,'tipos de perso del ejercito') --3
   ,(    1                  ,'Experto Esp.'         ,'tipos de perso del ejercito') --4

   ,(    2                  ,'Masculino'            ,'tipos de sexualidad') --5  
   ,(    2                  ,'Femenino'             ,'tipos de sexualidad') --6 
   ,(    2                  ,'Hibrido'              ,'tipos de sexualidad') --7 
   ,(    2                  ,'Asexual'              ,'tipos de sexualidad') --8 

   ,(    3                  ,'Soltero'              ,'tipos de estado civil Ecuador') --9 
   ,(    3                  ,'Casado'               ,'tipos de estado civil Ecuador') --10
   ,(    3                  ,'Divorciado'           ,'tipos de estado civil Ecuador') --11
   ,(    3                  ,'Viudo'                ,'tipos de estado civil Ecuador') --12

   ,(    4                  ,'Negro'                ,'tipos de etnia')
   ,(    4                  ,'Blanco'               ,'tipos de etnia')
   ,(    4                  ,'Mestizo'              ,'tipos de etnia')
   ,(    4                  ,'Indigena'             ,'tipos de etnia');





insert INTO IABot   (Nombre     ,Observacion                ) VALUES
                    ("IA-RUSO"  ,"Intelgencia Artificial"   );

INSERT INTO ExaBot (IdIABot      ,Nombre        ,Serie) VALUES
                   (1            ,"exabot1"     , "SerieE1")
                  ,(1            ,"exabot2"     , "SerieE2");

INSERT INTO Persona
    ( IdCatalogoTipoPersona ,IdCatalogoSexo ,IdCatalogoEstadoCivil  ,Cedula     ,Nombre              ,Apellido  ) VALUES
    ( 1                     ,5              ,9                      ,"11111"    ,"pepe"              ,"putin"   )
   ,( 2                     ,6              ,10                     ,"22222"    ,"Ana"             ,"putin"    )
   ,( 3                     ,5              ,11                     ,"33333"    ,"pedro"            ,"putin"    )
   ,( 4                     ,5              ,12                     ,"44444"    ,"pablo"            ,"putin"    )
   ,( 1                     ,6              ,9                      ,"010101"   ,"mecatro Luisa"     ,"putin"    )
   ,( 2                     ,5              ,10                     ,"020202"   ,"mecatro juan"     ,"putin"    )
   ,( 3                     ,5              ,11                     ,"030303"   ,"experto juan"     ,"putin"    )
   ,( 4                     ,6              ,12                     ,"040404"   ,"experto Sofi"     ,"putin"    );

SELECT * FROM Persona;

SELECT     IdCatalogo  
,IdCatalogoTipo        
,Nombre                
,Descripcion           
,Estado                
,FechaCreacion         
,FechaModifica         
FROM       CATALOGO    
WHERE      Estado = 'A' AND IdCatalogoTipo = 2;

SELECT COUNT(*) TotalReg                  
FROM Catalogo                            
WHERE Estado = 'A'
AND IdCatalogoTipo = 2