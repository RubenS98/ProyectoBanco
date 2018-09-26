
public class Tarjeta {
    protected String numero;
    protected double balance;
    protected static int pin;
    protected Fecha fechaExpi;
    protected Fecha fechaExpe;

    public Tarjeta(){}

    public Tarjeta(String numero, int pin, int mesexpe, int annoexpe) {
        this.numero = numero;
        this.pin = pin;
        fechaExpe = new Fecha(mesexpe, annoexpe);
        fechaExpi = new Fecha(mesexpe, annoexpe+5);
    }

    public void compras(double cantidad){}
    public void retiros(){}
    public void printTipo(){}
    public void printTarjeta(){}

    public String getNumero() {
        return numero;
    }
    public int getPin(){
        return pin;
    }
    public int getMese(){
        return fechaExpe.getMes();
    }
    public int getAnios(){
        return fechaExpe.getAnno();
    }
}
