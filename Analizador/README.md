cd "C:\ruta\a\Analizador"
ejecutar.bat

int x := 50
if x > 100 {
print x
}

N° | TIPO | VALOR
1 | PALABRA RESERVADA | int
2 | IDENTIFICADOR | x
3 | OPERADOR ASIGNACION | :=
...

No se encontraron errores léxicos

Analizador/
├── src/
│ ├── Token.java
│ ├── TipoError.java
│ ├── ErrorLexico.java
│ ├── Lexer.java
│ ├── GeneradorTabla.java
│ └── Main.java
├── bin/ (se crea automáticamente)
├── codigo_fuente.txt (edita este archivo)
├── ejecutar.bat (haz doble clic para ejecutar)
└── README.md (este archivo)


## Notas
- Solo edita el archivo `codigo_fuente.txt`
- No modifiques los archivos `.java`
- Cada vez que ejecutes, compila automáticamente los cambios