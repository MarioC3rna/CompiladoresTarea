import org.antlr.v4.runtime.*;
import java.io.IOException;
import java.util.*;

public class LexerDriver {
    // Mapeo de tokens a sus nombres
    static Map<Integer, String> tokenNames = new HashMap<>();
    
    static {
        tokenNames.put(AnalizadorLexer.IF, "Palabra_reservada");
        tokenNames.put(AnalizadorLexer.ELSE, "Palabra_reservada");
        tokenNames.put(AnalizadorLexer.FOR, "Palabra_reservada");
        tokenNames.put(AnalizadorLexer.PRINT, "Palabra_reservada");
        tokenNames.put(AnalizadorLexer.INT, "Palabra_reservada");
        tokenNames.put(AnalizadorLexer.ASDFG, "Palabra_reservada");
        tokenNames.put(AnalizadorLexer.ASDFG_IF, "Palabra_reservada");
        tokenNames.put(AnalizadorLexer.ASDFG_ELSE, "Palabra_reservada");
        tokenNames.put(AnalizadorLexer.ASDFG_FOR, "Palabra_reservada");
        tokenNames.put(AnalizadorLexer.ASDFG_PRINT, "Palabra_reservada");
        tokenNames.put(AnalizadorLexer.ASDFG_INT, "Palabra_reservada");
        
        tokenNames.put(AnalizadorLexer.PLUS, "Operador_Aritmetico");
        tokenNames.put(AnalizadorLexer.MINUS, "Operador_Aritmetico");
        tokenNames.put(AnalizadorLexer.TIMES, "Operador_Aritmetico");
        tokenNames.put(AnalizadorLexer.DIVIDE, "Operador_Aritmetico");
        
        tokenNames.put(AnalizadorLexer.ASSIGN, "Operador_Asignacion");
        
        tokenNames.put(AnalizadorLexer.GE, "Operador_Relacional");
        tokenNames.put(AnalizadorLexer.LE, "Operador_Relacional");
        tokenNames.put(AnalizadorLexer.GT, "Operador_Relacional");
        tokenNames.put(AnalizadorLexer.LT, "Operador_Relacional");
        tokenNames.put(AnalizadorLexer.EQ, "Operador_Relacional");
        tokenNames.put(AnalizadorLexer.NEQ, "Operador_Relacional");
        
        tokenNames.put(AnalizadorLexer.LBRACE, "Simbolo");
        tokenNames.put(AnalizadorLexer.RBRACE, "Simbolo");
        tokenNames.put(AnalizadorLexer.LBRACKET, "Simbolo");
        tokenNames.put(AnalizadorLexer.RBRACKET, "Simbolo");
        tokenNames.put(AnalizadorLexer.LPAREN, "Simbolo");
        tokenNames.put(AnalizadorLexer.RPAREN, "Simbolo");
        tokenNames.put(AnalizadorLexer.COMMA, "Simbolo");
        tokenNames.put(AnalizadorLexer.SEMICOLON, "Simbolo");
        tokenNames.put(AnalizadorLexer.DOTDOT, "Simbolo");
        
        tokenNames.put(AnalizadorLexer.NUMBER, "Numero");
        tokenNames.put(AnalizadorLexer.STRING, "Cadena");
        tokenNames.put(AnalizadorLexer.IDENTIFIER, "Identificador");
    }
    
    public static void main(String[] args) throws IOException {
        CharStream input = CharStreams.fromFileName("../ejemplos/codigo.txt");
        AnalizadorLexer lexer = new AnalizadorLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        tokens.fill();
        
        System.out.println("========== ANALIZADOR LEXICO ==========\n");
        for (Token token : tokens.getTokens()) {
            if (token.getType() != Token.EOF) {
                int type = token.getType();
                String tokenType = tokenNames.getOrDefault(type, "DESCONOCIDO");
                String tokenValue = token.getText();
                System.out.println(tokenType + " : " + tokenValue);
            }
        }
    }
}