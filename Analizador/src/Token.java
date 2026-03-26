public class Token {
    public enum Tipo {
        IDENTIFICADOR,
        NUMERO_ENTERO,
        CADENA,
        OPERADOR_ARITMETICO,
        OPERADOR_ASIGNACION,
        OPERADOR_RELACIONAL,
        SIMBOLO,
        PALABRA_RESERVADA,
        ERROR
    }

    private Tipo tipo;
    private String valor;

    public Token(Tipo tipo, String valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public String getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Token{" +
                "tipo=" + tipo +
                ", valor='" + valor + '\'' +
                '}';
    }
}