//Ruben estuvo aqui ayer y
public class Fecha{
    private int mes;
    private int anno;

    public Fecha(int mes, int anio) throws ArithmeticException {
        if (mes < 1 || mes > 12)
            throw new ArithmeticException();

        this.mes = mes;
        anno = anio;
    }

    public String FormatoFecha(){
        return String.format("%02d/%d", mes, anno);
    }
}
