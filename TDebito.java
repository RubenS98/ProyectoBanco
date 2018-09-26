
import java.util.*;

public class TDebito extends Tarjeta{
    private Fecha fechaExpi;
    private Fecha fechaExpe;

    public TDebito(String numero, int pin, double balance, int mesexpe, int annoexpe) {
        super(numero, pin, mesexpe, annoexpe);
        this.balance = balance;

    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public void compras(double cantidad) {
        if (cantidad > balance)
            System.out.println("Fondos insuficientes.\n");

        else{
            balance -= cantidad;
            System.out.println("Transaccion exitosa.\n");
        }
    }

    @Override
    public void retiros() {
        Scanner lector = new Scanner(System.in);
        boolean err = true;
        double cantidad;

        while (err) {
            try {
                System.out.print("Ingrese la cantidad a retirar: ");
                cantidad = lector.nextDouble();

                if (cantidad > balance) {
                    System.out.println("Fondos insuficientes");
                    err = true;
                }

                else {
                    balance -= cantidad;
                    System.out.println("Retiro exitoso");
                    System.out.println("Nuevo balance: " + balance);

                    err = false;
                }

            }
            catch (InputMismatchException ime) {
                System.err.println("Error: No se pueden teclear letras");
                lector.nextLine();
            }
        }
    }


    @Override
    public void printTarjeta() {
        System.out.printf("\nTarjeta de Debito: %s\nSaldo: %.2f\n", numero, balance);
        System.out.printf("Fecha de Expedición: %s\nFecha de Expiración: %s\n\n",
            fechaExpe.FormatoFecha(), fechaExpi.FormatoFecha());
    }

}
