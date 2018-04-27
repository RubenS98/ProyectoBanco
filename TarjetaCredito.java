//Ejemplo de composición

import java.util.*;

public class TarjetaCredito{
    private TipoTC tipoTC;
    private Fecha fechaExpi;
    private Fecha fechaExpe;
    private String numero;
    private double saldo;
    private int numTarjeta;
    private static int contTarj = 0;

    public TarjetaCredito(){ }

    public TarjetaCredito(String numero, double saldo, int mesexpe, int annoexpe,
            int mesexpi, int annoexpi, TipoTC tipoTC){
            contTarj++;
            numTarjeta = contTarj;
            this.numero=numero;
            this.saldo=saldo;
            fechaExpi = new Fecha(mesexpi, annoexpi);
            fechaExpe = new Fecha(mesexpe, annoexpe);
            this.tipoTC = tipoTC;
        }



    public void setTipoTC(TipoTC tipoTC){
        this.tipoTC = tipoTC;
    }
    public String getNumero(){
        return numero;
    }
    public double getSaldo(){
        return saldo;
    }
    public int getNumTarjeta(){
        return numTarjeta;
    }

    public void compras(double cantidad){
        if(cantidad > saldo)
            System.out.println("Fondos insuficientes");

        else
            saldo = saldo - cantidad;
    }

    public void pickFecha(){
      Fecha fecha;
      Scanner lector = new Scanner(System.in);
      boolean err = true;
      while(err){
        try{
          System.out.print("Ingrese la fecha de expiración de la tarjeta: ");
          int month = lector.nextInt();
          int year = lector.nextInt();
          fecha = new Fecha(month, year);
          if (month == fechaExpi.getMes() && year == fechaExpi.getAnno()) {
            fecha = fechaExpi;
            retiros();
          } else{
            System.out.print("Fecha incorrecta, intente nuevamente: ");
          }
          err = false;
        }
        catch(ArithmeticException ae){
          System.err.println("Error: Fecha inexistente");
          lector.nextLine();
        }
      }
    }

    public void retiros(){
      Scanner lector = new Scanner(System.in);
      boolean err = true;
      while(err){
        try{
          err = true;
          System.out.print("Ingrese la cantidad a retirar: ");
          double cantidad = lector.nextDouble();
          if (cantidad > saldo) {
            System.out.println("Fondos insuficientes");
            retiros();
          } else {
            saldo = saldo - cantidad;
            System.out.println("Transacción exitosa");
            System.out.println("Nuevo saldo: " + saldo);
          }
          err = false;
        }
        catch(InputMismatchException ime){
          System.err.println("Error: No se pueden teclear letras");
          lector.nextLine();
        }
      }
    }

    public void printTC(){
        System.out.printf("\nNum. Tarjeta: %d\nTarjeta de Crédito: %s\nSaldo: %.2f\n", numTarjeta, numero, saldo);
        printTipo();
        System.out.printf("Fecha de Expedición: %s\nFecha de Expiración: %s\n\n",
                fechaExpe.FormatoFecha(), fechaExpi.FormatoFecha());
    }

    public void printTipo(){
        switch(tipoTC){
            case CLASICA:
                System.out.println("Tipo de Tarjeta: CLASICA");
                break;
            case ORO:
                System.out.println("Tipo de Tarjeta: ORO");
                break;
            case PLATINO:
                System.out.println("Tipo de Tarjeta: PLATINO");
                break;
            case BLACK:
                System.out.println("Tipo de Tarjeta: BLACK");
                break;
            default:
                System.out.println("No existe");
        }

        System.out.printf("Tasa de interes mensual: %.2f%nTasa de interes anual: %.2f%n",
                tipoTC.TIM(), tipoTC.TIA());
    }
}
