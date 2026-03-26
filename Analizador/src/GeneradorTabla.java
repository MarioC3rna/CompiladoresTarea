import java.util.List;

public class GeneradorTabla {

    public static void imprimirTabla(List<Token> tokens, String nombreArchivo) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("TABLA DE TOKENS - Archivo: " + nombreArchivo);
        System.out.println("=".repeat(60));
        System.out.printf("%-5s | %-25s | %-25s%n", "N°", "TIPO", "VALOR");
        System.out.println("-".repeat(60));

        if (tokens.isEmpty()) {
            System.out.println("No se encontraron tokens.");
        } else {
            for (int i = 0; i < tokens.size(); i++) {
                Token token = tokens.get(i);
                String tipo = formatearTipo(token.getTipo());
                System.out.printf("%-5d | %-25s | %-25s%n", (i + 1), tipo, token.getValor());
            }
        }

        System.out.println("=".repeat(60));
    }

    public static void imprimirTablaErrores(List<ErrorLexico> errores) {
        System.out.println("\n" + "=".repeat(90));
        System.out.println("TABLA DE ERRORES LÉXICOS");
        System.out.println("=".repeat(90));

        if (errores.isEmpty()) {
            System.out.println("No se encontraron errores léxicos");
        } else {
            System.out.printf("%-5s | %-25s | %-15s | %-40s%n", "N°", "TIPO DE ERROR", "VALOR", "DESCRIPCIÓN");
            System.out.println("-".repeat(90));

            for (int i = 0; i < errores.size(); i++) {
                ErrorLexico error = errores.get(i);
                System.out.printf("%-5d | %-25s | %-15s | %-40s%n",
                        (i + 1),
                        error.getNombreTipo(),
                        error.getValor(),
                        error.getDescripcion());
            }
        }

        System.out.println("=".repeat(90));
    }

    private static String formatearTipo(Token.Tipo tipo) {
        return tipo.toString().replace('_', ' ');
    }
}