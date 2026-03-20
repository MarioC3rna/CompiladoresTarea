lexer grammar AnalizadorLexer;

// PALABRAS RESERVADAS
IF: 'if' | 'If' | 'IF';
ELSE: 'else' | 'Else' | 'ELSE';
FOR: 'for' | 'For' | 'FOR';
PRINT: 'print' | 'Print' | 'PRINT';
INT: 'int' | 'Int' | 'INT';

// PALABRAS RESERVADAS CON 'asdfg'
ASDFG: 'asdfg';
ASDFG_IF: 'asdfgif' | 'asdfgIf' | 'asdfgIF';
ASDFG_ELSE: 'asdfgelse' | 'asdfgElse' | 'asdfgELSE';
ASDFG_FOR: 'asdfgfor' | 'asdfgFor' | 'asdfgFOR';
ASDFG_PRINT: 'asdfgprint' | 'asdfgPrint' | 'asdfgPRINT';
ASDFG_INT: 'asdfgint' | 'asdfgInt' | 'asdfgINT';

// OPERADORES ARITMETICOS
PLUS: '+';
MINUS: '-';
TIMES: '*';
DIVIDE: '/';

// OPERADOR DE ASIGNACION
ASSIGN: ':=';

// OPERADORES RELACIONALES
GE: '>=';
LE: '<=';
GT: '>';
LT: '<';
EQ: '=';
NEQ: '<>';

// SIMBOLOS ESPECIALES
LBRACE: '{';
RBRACE: '}';
LBRACKET: '[';
RBRACKET: ']';
LPAREN: '(';
RPAREN: ')';
COMMA: ',';
SEMICOLON: ';';
DOTDOT: '..';

// NUMEROS (0-100)
NUMBER: [0-9]+ ;

// CADENAS CON 'asdfg'
STRING: '"asdfg"' | '\'asdfg\'';

// IDENTIFICADORES (maximo 10 caracteres, comienza con letra, resto letras o digitos)
IDENTIFIER: [a-zA-Z] ([a-zA-Z0-9])* ;

// ESPACIOS EN BLANCO
WS: [ \t\n\r]+ -> skip;