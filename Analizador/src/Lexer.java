import java.util.*;
import java.util.regex.*;

public class Lexer {
    private String codigo;
    private List<Token> tokens;
    private List<ErrorLexico> errores;

    // Palabras reservadas
    private static final Set<String> PALABRAS_RESERVADAS = new HashSet<>(Arrays.asList(
        "if", "else", "for", "print", "int", "asdfg"
    ));

    // Patrones en orden de especificidad (de más específico a más general)
    private static final String PATRON_ASIGNACION = ":=";
    private static final String PATRON_OPERADOR_DOBLE = "(==|<=|>=|<>|\\.\\./)";
    private static final String PATRON_NUMERO = "\\d+";
    private static final String PATRON_IDENTIFICADOR = "[a-zA-Z][a-zA-Z0-9]*";
    private static final String PATRON_OPERADOR_ARITMETICO = "[+\\-*/]";
    private static final String PATRON_OPERADOR_RELACIONAL = "[=<>!]";
    private static final String PATRON_SIMBOLO = "[{}\\[\\](),;]";

    public Lexer(String codigo) {
        this.codigo = codigo;
        this.tokens = new ArrayList<>();
        this.errores = new ArrayList<>();
    }

    public List<Token> analizar() {
        tokens.clear();
        errores.clear();

        int i = 0;
        while (i < codigo.length()) {
            char c = codigo.charAt(i);

            // Ignorar espacios en blanco
            if (Character.isWhitespace(c)) {
                i++;
                continue;
            }

            // Intentar operador de asignación :=
            if (i + 1 < codigo.length() && c == ':' && codigo.charAt(i + 1) == '=') {
                tokens.add(new Token(Token.Tipo.OPERADOR_ASIGNACION, ":="));
                i += 2;
                continue;
            }

            // Si hay solo ':' sin '='
            if (c == ':') {
                errores.add(new ErrorLexico(TipoError.ASIGNACION_INCOMPLETA, ":"));
                i++;
                continue;
            }

            // Operadores relacionales dobles: <=, >=, <>, ==
            if (i + 1 < codigo.length()) {
                String dos = "" + c + codigo.charAt(i + 1);
                if (dos.equals("<=") || dos.equals(">=") || dos.equals("<>") || dos.equals("==")) {
                    tokens.add(new Token(Token.Tipo.OPERADOR_RELACIONAL, dos));
                    i += 2;
                    continue;
                }
            }

            // Operador rango ..
            if (i + 1 < codigo.length() && c == '.' && codigo.charAt(i + 1) == '.') {
                tokens.add(new Token(Token.Tipo.OPERADOR_RELACIONAL, ".."));
                i += 2;
                continue;
            }

            // Si hay solo '.' sin otro '.'
            if (c == '.') {
                errores.add(new ErrorLexico(TipoError.PUNTO_INVALIDO, "."));
                i++;
                continue;
            }

            // Números enteros
            if (Character.isDigit(c)) {
                StringBuilder num = new StringBuilder();
                while (i < codigo.length() && Character.isDigit(codigo.charAt(i))) {
                    num.append(codigo.charAt(i));
                    i++;
                }
                String valor = num.toString();
                int numero = Integer.parseInt(valor);

                if (numero > 100) {
                    errores.add(new ErrorLexico(TipoError.NUMERO_FUERA_RANGO, valor));
                } else {
                    tokens.add(new Token(Token.Tipo.NUMERO_ENTERO, valor));
                }
                continue;
            }

            // Identificadores y palabras reservadas
            if (Character.isLetter(c)) {
                StringBuilder ident = new StringBuilder();
                while (i < codigo.length() && (Character.isLetterOrDigit(codigo.charAt(i)))) {
                    ident.append(codigo.charAt(i));
                    i++;
                }
                String valor = ident.toString();

                if (valor.length() > 10) {
                    errores.add(new ErrorLexico(TipoError.IDENTIFICADOR_LARGO, valor));
                } else if (PALABRAS_RESERVADAS.contains(valor.toLowerCase())) {
                    tokens.add(new Token(Token.Tipo.PALABRA_RESERVADA, valor));
                } else {
                    tokens.add(new Token(Token.Tipo.IDENTIFICADOR, valor));
                }
                continue;
            }

            // Operadores aritméticos
            if ("+-*/".indexOf(c) >= 0) {
                tokens.add(new Token(Token.Tipo.OPERADOR_ARITMETICO, "" + c));
                i++;
                continue;
            }

            // Operadores relacionales simples: =, <, >
            if ("=<>".indexOf(c) >= 0) {
                tokens.add(new Token(Token.Tipo.OPERADOR_RELACIONAL, "" + c));
                i++;
                continue;
            }

            // Símbolos: {, }, [, ], (, ), ,, ;
            if ("{}[](),;".indexOf(c) >= 0) {
                tokens.add(new Token(Token.Tipo.SIMBOLO, "" + c));
                i++;
                continue;
            }

            // Carácter inválido (no reconocido)
            errores.add(new ErrorLexico(TipoError.CARACTER_INVALIDO, "" + c));
            i++;
        }

        return tokens;
    }

    public List<ErrorLexico> getErrores() {
        return errores;
    }
}