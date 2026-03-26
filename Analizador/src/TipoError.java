public enum TipoError {
    NUMERO_FUERA_RANGO("NÚMERO FUERA DE RANGO", "El número es mayor a 100 o contiene caracteres inválidos"),
    IDENTIFICADOR_LARGO("IDENTIFICADOR LARGO", "El identificador excede 10 caracteres"),
    CARACTER_INVALIDO("CARÁCTER INVÁLIDO", "Se encontró un carácter no reconocido en el código"),
    ASIGNACION_INCOMPLETA("ASIGNACIÓN INCOMPLETA", "Se encontró ':' sin el '=' del operador ':='"),
    PUNTO_INVALIDO("PUNTO INVÁLIDO", "Se encontró un punto solitario sin formar '..'");

    private String nombre;
    private String descripcion;

    TipoError(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}