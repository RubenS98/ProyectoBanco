
import java.util.*;

public class TCredito extends Tarjeta{
    private TipoTC tipoTC;

    public TCredito(){}
    public TCredito(String numero, int pin, int mesexpe, int annoexpe, TipoTC tipoTC) {
        super(numero, pin, mesexpe, annoexpe);
        balance = 0;
        this.tipoTC = tipoTC;
    }
    public TCredito(String numero, int pin, int mesexpe, int annoexpe, TipoTC tipoTC, double balance) {
        super(numero, pin, mesexpe, annoexpe);
        this.balance=balance;
        this.tipoTC = tipoTC;
    }

    public void setTipoTC(TipoTC tipoTC) {
        this.tipoTC = tipoTC;
    }
    public TipoTC getTipoTC() {
        return tipoTC;
    }
    public String getNumero() {
        return numero;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean pickPin(int opcion) {
        int nip, intentos = 3;
        double monto;
        Scanner lector = new Scanner(System.in);
        boolean err = true, status = false;
        while (err) {
            try {
                do{
                System.out.println("Ingrese el NIP de la tarjeta Tiene "+intentos+" intento(s)");
                nip = lector.nextInt();

                if (nip == getPin()) {
                    System.out.println("Contrasenia es correcta.");
                    switch(opcion){
                      case 1:
                        this.retiros();
                          break;
                      case 2:
                        System.out.println("Monto a pagar: ");
                            monto = lector.nextDouble();
                          this.pagos(monto);
                          break;
                      case 3:
                            System.out.println("Monto a cobrar: ");
                            monto = lector.nextDouble();
                            this.compras(monto);
                          break;
                    case 4:     
                        printTarjeta();
                        break;
                      default:
                      break;
                    }
                    status = true;
                    } else {
                        System.out.print("NIP incorrecto, intente nuevamente: ");
                        intentos--;
                        status = false;
                    }

                 } while(status == false && intentos > 0);

                 err = false;
                } catch (InputMismatchException ime) {
                    System.err.println("Error: No se pueden teclear letras. \n");
                    lector.nextLine();
                }

            }
            return status;
        }


    public void pagos(double cantidad){
        if ((balance - cantidad) < 0)
            System.out.println("Esta pagando de más.\n");

        else{
            balance -= cantidad;
            System.out.println("Pago exitosa.");
            System.out.println("Nuevo balance: " + balance);
        }
    }
    
    @Override
    public void compras(double cantidad) {
        if ((cantidad + balance) > tipoTC.getLimite())
            System.out.println("Fondos insuficientes.\n");

        else{
            balance -= cantidad;
            System.out.println("Transaccion exitosa.");
            System.out.println("Nuevo balance: " + balance);
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

                if ((cantidad + balance) > tipoTC.getLimite()) {
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
    public void printTipo() {
        switch (tipoTC) {
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

    @Override
    public void printTarjeta() {
        System.out.printf("\nTarjeta de Crédito: %s\nSaldo: %.2f\nLimite Credito: %.2f\n", numero, balance, tipoTC.getLimite());
        printTipo();
        System.out.printf("Fecha de Expedición: %s\nFecha de Expiración: %s\n\n",
            fechaExpe.FormatoFecha(), fechaExpi.FormatoFecha());
    }

}
