
public class Fecha {
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
      throw new ArithmeticException("Los meses van del 1 al 12. Vuelva a intenarlo presionando enter.");

    if ((dia < 1 || dia > 31))
      throw new ArithmeticException("Los dias van del 1 al 31. Vuelva a intenarlo presionando enter.");

    if (mes == 2 && dia > 29)
      throw new ArithmeticException("Febrero no puede tener más de 29 días. Vuelva a intenarlo presionando enter.");

    this.dia = dia;
    this.mes = mes;
    anno = anio;
  }

  public String FormatoFecha() {
    return String.format("%02d/%d", mes, anno);
  }

  public String FormatoFecha2() {
    return String.format("%02d/%02d/%d", dia, mes, anno);
  }

  public int getDia(){
    return dia;
  }

  public int getMes() {
    return mes;
  }

  public int getAnno() {
    return anno;
  }
}
