public class ErrorLexico {
    private TipoError tipoError;
    private String valor;

    public ErrorLexico(TipoError tipoError, String valor) {
        this.tipoError = tipoError;
        this.valor = valor;
    }

    public TipoError getTipoError() {
        return tipoError;
    }

    public String getValor() {
        return valor;
    }

    public String getNombreTipo() {
        return tipoError.getNombre();
    }

    public String getDescripcion() {
        return tipoError.getDescripcion();
    }

    @Override
    public String toString() {
        return "ErrorLexico{" +
                "tipoError=" + tipoError +
                ", valor='" + valor + '\'' +
                '}';
    }
}