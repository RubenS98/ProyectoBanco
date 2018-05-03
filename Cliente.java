import java.util.*;

public class Cliente{
    private int id;
    private static int contid = 0, tarjetaNum = 0;
    private String nombre, apellido, direccion;
    private Fecha fechaNacimiento;
    private long telefono;
    private ArrayList<TarjetaCredito> listaTC = new ArrayList<>();

    public Cliente(String nombre, String apellido, String direccion, int dia, int mes, int anio, long telefono){
        contid++;
        id = contid;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion=direccion;
        fechaNacimiento=new Fecha(dia, mes, anio);
        this.telefono=telefono;
    }

    public void removeTarjeta(int pos){
        listaTC.remove(pos);
    }

    public void setTarjetaCredito(TarjetaCredito tc){
        listaTC.add(tc);
    }
    public void setNom(String nom){
        this.nombre=nom;
    }
    public void setAp(String ap){
        this.apellido=ap;
    }
    public void setDir (String direccion){
        this.direccion=direccion;
    }
    public void setTel (long telefono){
        this.telefono=telefono;
    }

    public String getNom(){
        return nombre;
    }
    public int getID(){
        return id;
    }

    public double getBalanceTarjeta(int posicion){
        return listaTC.get(posicion - 1).getSaldo();
    }


    public void printCliente(){
        System.out.printf("\nId: %d\nNombre: %s, %s\nDireccion: %s\n", id, apellido, nombre, direccion);
        if(listaTC.size() > 0)
            for(int cont = 0; cont < listaTC.size(); cont++)
                    listaTC.get(cont).printTC();
        else
            System.out.println("El cliente no tiene asignada tarjetas de crédito \n");
    }

    public void printTarjetas(){
        for(int cont = 0; cont < listaTC.size(); cont++){
            listaTC.get(cont).printTC();
        }
    }

    public void pickTarjeta(){
      TarjetaCredito tarjeta;
      Scanner lector = new Scanner(System.in);
      System.out.println("Ingrese el número de la tarjeta");
      String num = lector.nextLine();
      for (int i=0; i<listaTC.size(); i++) {
        if (num.equals(listaTC.get(i).getNumero())) {
          tarjeta = listaTC.get(i);
          tarjeta.pickFecha();
        }
      }
    }
}
