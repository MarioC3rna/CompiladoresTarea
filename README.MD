# Analizador Léxico - ANTLR

## Información

**Analizador léxico** que divide código fuente en tokens (palabras reservadas, identificadores, números, operadores, símbolos).

### Archivos Principales

- `AnalizadorLexer.g4` - Definición de tokens
- `LexerDriver.java` - Programa principal
- `ejemplos/codigo.txt` - Archivo de entrada

### Tokens Soportados

| Tipo | Ejemplos |
|------|----------|
| Palabras reservadas | if, else, for, print, int, asdfg |
| Identificadores | máx 10 caracteres, comienzan con letra |
| Números | 0-100 |
| Operadores | +, -, *, /, :=, >=, <=, >, <, =, <> |
| Símbolos | { } [ ] ( ) , ; .. |

---

## Comandos

### Compilar

```bash
cd lexer
javac -cp ".:../ANTLR/antlr-4.13.1-complete.jar" LexerDriver.java
```

**Carpetas generadas:**
- `lexer/` - Contiene archivos `.class` compilados:
  - `LexerDriver.class`
  - `AnalizadorLexer.class`
  - Otros archivos `.class` auxiliares

### Ejecutar

```bash
java -cp ".:../ANTLR/antlr-4.13.1-complete.jar" LexerDriver
```

**Salida en consola:** Lista de tokens reconocidos del archivo `ejemplos/codigo.txt`

**Carpetas utilizadas:**
- `lexer/generated/` - Contiene archivos ANTLR generados:
  - `AnalizadorLexer.java`
  - `AnalizadorLexer.interp`
  - `AnalizadorLexer.tokens`
- `ejemplos/` - Contiene:
  - `codigo.txt` (archivo de entrada a analizar)

   