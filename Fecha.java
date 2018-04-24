//Ruben estuvo aqui ayer y hoy
public class Fecha{
    private int dia;
    private int mes;
    private int anno;

    public Fecha(int mes, int anio) throws ArithmeticException {
        if (mes < 1 || mes > 12)
            throw new ArithmeticException();

        this.mes = mes;
        anno = anio;
    }

    public Fecha(int dia, int mes, int anio) throws ArithmeticException {
        if (mes < 1 || mes > 12)
            throw new ArithmeticException();

        if (dia < 1 || dia > 31)
            throw new ArithmeticException();

        this.dia=dia;
        this.mes = mes;
        anno = anio;
    }

    public String FormatoFecha(){
        return String.format("%02d/%d", mes, anno);
    }

    public String FormatoFecha2(){
        return String.format("%02d/%02d/%d", mes, anno);
    }

    public int getMes(){
      return mes;
    }

    public int getAnno(){
      return anno;
    }
}
