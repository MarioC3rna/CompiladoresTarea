import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Leer el archivo de código fuente
            String rutaArchivo = "codigo_fuente.txt";
            String codigo = new String(Files.readAllBytes(Paths.get(rutaArchivo)));

            // Crear el lexer y analizar
            Lexer lexer = new Lexer(codigo);
            List<Token> tokens = lexer.analizar();
            List<ErrorLexico> errores = lexer.getErrores();

            // Imprimir las tablas
            GeneradorTabla.imprimirTabla(tokens, rutaArchivo);
            GeneradorTabla.imprimirTablaErrores(errores);

            // Resumen
            System.out.println("\nRESUMEN:");
            System.out.println("Tokens encontrados: " + tokens.size());
            System.out.println("Errores encontrados: " + errores.size());

        } catch (Exception e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}