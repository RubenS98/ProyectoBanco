import java.util.*;

public class TESTMainCliente {
    static ArrayList<Cliente> listaClientes = new ArrayList();

    public static void main(String[] args){

        System.out.println("\nPara Una Mejor Experiencia, "
        + "tenga la terminal en Pantalla Completa...\n");

        System.out.println("SISTEMA DE ALTA DE CLIENTES\n");

        TarjetaCredito tc = new TarjetaCredito("5538274927", 48000.00, 10, 2015, 10, 2019, TipoTC.PLATINO);
        TipoTC tPlatino = TipoTC.PLATINO;
        //Cliente
        Cliente c = new Cliente("Juan", "Pérez", 28);

        listaClientes.add(c);

        c.setTarjetaCredito(tc);
        c.printCliente();

        System.out.println("");

        menu();
    }//fin Main

    public static void menu(){
        Scanner lc = new Scanner(System.in);
        String lasOpciones;
        boolean selMenu = true, err = true;
        int opcion;

        lasOpciones="\n MENU\n";
        lasOpciones+="\t1.- Retiros (99% completado, faltan excepciones)\n";
        lasOpciones+="\t2.- Depositos (falta)\n";
        lasOpciones+="\t3.- Transferencias (falta)\n";
        lasOpciones+="\t4.- Compras (falta)\n";
        lasOpciones+="\t5.- Administracion de Cuentas(98% done)\n";
        lasOpciones+="\t 6.- Salir \n";
        lasOpciones+="";
        lasOpciones+="Elija la opcion que quiera: ";

        System.out.print(lasOpciones);

        while(err){
            try{
                do{
                  opcion=lc.nextInt();
                  lc.nextLine();
                  switch(opcion){
                    case 1:
                      retirosMenu();
                      selMenu = true;
                      break;
                    case 2:
                      depositos();
                      selMenu = true;
                      break;
                    case 3:
                      transferencias();
                      selMenu = true;
                      break;
                    case 4:
                      compras();
                      selMenu = true;
                      break;
                    case 5:
                      menu2();
                      selMenu = true;
                      break;
                    case 6:
                      System.out.println("Adios\n");
                      System.exit(0);
                      break;
                    default:
                      System.out.print("Opcion no existe, elige entre 1 y 6: ");
                      selMenu = false;
                      break;
                  }
                }while(selMenu == false);
            }//fin try
            catch(InputMismatchException ime) {
                System.err.println("Error: No se pueden teclear letras. \n");
                lc.nextLine();
                System.out.print("Seleccione entre 1 y 6: ");
            }
        }//fin err
    }//fin Menu

    public static void menu2(){
        Scanner lc = new Scanner(System.in);
        String modificacionC;
        char mod;
        boolean selMenu = true;

        System.out.printf("%nAdministracion de Cuentas%n"
                + "\t a. Alta Cliente%n"
                + "\t b. Baja Cliente%n"
                + "\t c. Modificacion Datos Personales%n"
                + "\t d. Cambiar TipoTC (falta)%n"
                + "\t e. Agregar Tarjeta a Cliente%n"
                + "\t f. Imprimir Datos%n"
                + "\t  g. Regresar a menu%n"
                + "\t  h. Salir%n%n"
                + "Teclee la letra que quiera: ");

        while(selMenu){
            modificacionC = lc.nextLine();
            mod = modificacionC.charAt(0);
            switch(mod){
                case 'a':
                  aC();
                  selMenu = false;
                  break;
                case 'b':
                  bC();
                  selMenu = false;
                  break;
                case 'c':
                  mDC();
                  selMenu = false;
                  break;
                case 'd':
                  mDT();
                  selMenu = false;
                  break;
                case 'e':
                  aTCE();
                  selMenu = false;
                  break;
                case 'f':
                  iD();
                  selMenu = false;
                  break;
                case 'g':
                  menu();
                  selMenu = false;
                  break;
                case 'h':
                    System.out.println("Adios\n");
                    System.exit(0);
                    break;
                default:
                    System.out.print("Opcion no existe, elige entre 'a' y 'h': ");
                    selMenu = true;
                    break;
            }
        }
    }//fin MENU2

    public static void retirosMenu(){
        Cliente cliente;
        Scanner lc = new Scanner(System.in);
        System.out.println("Ingrese su nombre");
        String nombre = lc.nextLine();
        for (int i=0; i<listaClientes.size(); i++) {
          String n = listaClientes.get(i).getNom();
          if (nombre.equals(n)) {
            cliente = listaClientes.get(i);
            cliente.pickTarjeta();
          }
        }
        menu();
    }//fin RETIROS

    public static void depositos(){
        System.out.println("FALTA Depositos... Regresando a Menu");

        menu();
    }//fin DEPOSITOS

    public static void transferencias(){
        System.out.println("FALTA Transferencias... Regresando a Menu");

        menu();
    }//fin TRANSFERENCIAS

    public static void compras(){
        System.out.println("FALTA Compras... Regresando a Menu");

        menu();
    }//fin COMPRAS

    public static void aC(){
            Scanner lc = new Scanner(System.in);
            String ansCard, ans;
            boolean err = true;

            Cliente c;
            String nom, ap;
            int edad;

            while(err){
                try{
                    do{
                      System.out.print("\nNombre del Cliente: ");
                        nom = lc.nextLine();

                      System.out.print("Apellido(s) del Cliente: ");
                        ap = lc.nextLine();

                      System.out.print("Edad del Cliente: ");
                        edad = lc.nextInt();
                        lc.nextLine();

                      c = new Cliente(nom, ap, edad);

                      System.out.printf("Se ha creado al Cliente %s con el folio %d.%n%n", nom, c.getID());

                      do{
                        System.out.print("Desea agregarle una tarjeta ahora? [Y/N]: ");
                          ansCard = lc.nextLine();

                        if(ansCard.equalsIgnoreCase("Y"))
                          aTC(c);

                        else if(ansCard.equalsIgnoreCase("N"))
                          listaClientes.add(c);

                        else
                              System.out.println("Respuesta no válida. Seleccione 'N' o 'Y'.");
                      }while(!ansCard.equalsIgnoreCase("y") && !ansCard.equalsIgnoreCase("n"));

                      System.out.printf("Quieres agregar un cliente nuevo? [Y/N]: ");
                          ans = lc.nextLine();
                    }while(ans.equalsIgnoreCase("Y"));

                    err = false;
                }//fin try
                catch (InputMismatchException ime) {
                    System.err.println("Error: No se pueden teclear letras en la edad. \n");
                    lc.nextLine();
                }
            }//fin err

            menu();
        }//fin Agregar CLIENTE

    public static void aTC(Cliente client){
        Scanner lc = new Scanner(System.in);
        int typeCard;
        boolean selCard, err = true;

        TarjetaCredito tc = new TarjetaCredito();
        String numero;
        int month, year;
        int balance;

        System.out.println("\n Tajetas Disponibles:\n");

        for (TipoTC t : TipoTC.values())
          System.out.printf("La TIIE de la %s es: %.2f%% %n"
          + "Su Tasa Mensual es: %.2f%% %n"
          + "Su Tasa Anual es: %.2f%% %n"
          + "%n", t, t.TIIE(), t.TIM(), t.TIA());

        System.out.printf("Seleccione la opcion de la tarjeta que desea: %n%n"
        + "1: Clásica: \t\t\t 2: Oro \t\t\t 3: Platinum \t\t\t 4: Black%n"
        + "Ingresos mínimos: $7,500 \t Ingresos mínimos: $15,000\t"
        + " Ingresos mínimos: $45,000\t Ingresos mínimos: $100,000%n"
        + "Anualidad: $699 \t\t Anualidad: $959 \t\t Anualidad:1,999 \t\t Anualidad:4,599 %n%n");

        while(err){
            try{
                do{
                    System.out.print("Seleccione [1, 2, 3 o 4]: ");
                        typeCard = lc.nextInt();
                        lc.nextLine();

                    if(typeCard > 4 || typeCard < 1){
                        System.out.println("Esa opción no es válida \n");
                        selCard = false;
                    }

                    else{
                        System.out.println("Numero Tarjeta? [16 Digitos]: ");
                            numero = lc.nextLine();

                        System.out.println("Fecha de expedicion? [MM AAAA]: ");
                            month = lc.nextInt();
                            year = lc.nextInt();

                        System.out.println("Balance?: ");
                            balance = lc.nextInt();


                        switch(typeCard){
                          case 1:
                            tc = new TarjetaCredito(numero, balance, month, year, month, (year+5), TipoTC.CLASICA);
                            System.out.println("Su tarjeta Clasica ha quedado registrada.\n");
                            selCard = true;
                            break;
                          case 2:
                            tc = new TarjetaCredito(numero, balance, month, year, month, (year+5), TipoTC.ORO);
                            System.out.println("Su tarjeta Oro ha quedado registrada\n");
                            selCard = true;
                            break;
                          case 3:
                            tc = new TarjetaCredito(numero, balance, month, year, month, (year+5), TipoTC.PLATINO);
                            System.out.println("Su tarjeta Platino ha quedado registrada\n");
                            selCard = true;
                            break;
                          case 4:
                            tc = new TarjetaCredito(numero, balance, month, year, month, (year+5), TipoTC.BLACK);
                            System.out.println("Su tarjeta BLACK ha quedado registrada\n");
                            selCard = true;
                            break;
                          default:
                            System.out.println("Opcion no valida. Elija entre 1 y 4.\n");
                            selCard = false;
                            break;
                        }//switch
                    }//else
                }while(selCard == false);

                client.setTarjetaCredito(tc);

                listaClientes.add(client);

                err = false;
            }//fin try
            catch (ArithmeticException ex) {
                    System.err.println("Error: Fecha no existe. \n");
            }
            catch (InputMismatchException ime) {
                    System.err.println("Error: No se pueden teclear letras. \n");
                    lc.nextLine();
            }
        }//fin err
    }//fin de addTarejta

    public static void bC(){
        Scanner lc = new Scanner(System.in);
        String ans;
        boolean idfound = true;
        int opcion, sel = -1;

        if(listaClientes.isEmpty())
            System.out.println("\n No hay clientes registrados, regresando al Menu...\n");

        else{
            try{
                System.out.println("Si se sabe el ID del cliente a dar de baja, escribalo, "
                        + "si no, escriba 0 para imprimir todos los clientes, o -1 para regresar a menu.");

                while (idfound){
                    opcion = lc.nextInt();
                    lc.nextLine();

                    if(opcion == -1){
                        System.out.println("Regresnado a Menu...\n");
                        idfound = false;
                    }

                    else if(opcion == 0){
                        for(int cont = 0; cont < listaClientes.size(); cont++)
                            System.out.println("ID: " + listaClientes.get(cont).getID() +
                                    " Nombre: " + listaClientes.get(cont).getNom());

                        System.out.print("\nDigite el Id del Cliente que quiere dar de baja: ");
                        idfound = true;
                    }

                    else if(opcion > 0){
                        for(int cont = 0; cont < listaClientes.size(); cont++){
                            if(listaClientes.get(cont).getID() == opcion){
                                listaClientes.get(cont).printCliente();

                                System.out.println("\n DAR DE BAJA CLIENTE? [Y/N]");
                                ans = lc.nextLine();

                                if(ans.equalsIgnoreCase("Y")){
                                    listaClientes.remove(cont);
                                    System.out.println("Cliente ha sido eliminado.\n");
                                    sel = 1;
                                }

                                else{
                                   System.out.print("\nDigite el Id del Cliente que quiere dar de baja: ");
                                   sel = 2;
                                }
                            }

                            else
                                sel = 3;
                        }

                        switch (sel) {
                            case 1:
                                idfound = false;
                                break;
                            case 2:
                                idfound = true;
                                break;
                            case 3:
                                System.out.println("No se encontro el Id de ese cliente, intente de nuevo.");
                                idfound = true;
                                break;
                        }
                    }

                    else{
                        System.out.println("\nEl Id no existe");

                        System.out.print("Digite el Id del Cliente que quiere dar de baja: ");
                        idfound = true;
                    }
                }//fin while idfound
            }//fin try
            catch(InputMismatchException ime){
                System.err.println("Error: No se pueden teclear letras. \n");
                lc.nextLine();
            }
        }

        menu();
    }//fin baja de cliente

    public static void mDC(){
        Scanner lc = new Scanner(System.in);
        String newNom, newAp;
        String toModify;
        int newEdad, opcion, position = -1;
        char change;
        boolean idfound = true, sel = true, found = false;

        if(listaClientes.isEmpty())
            System.out.println("\n No hay clientes registrados, regresando al Menu...\n");

        else{
          //while(err){
            try{
                System.out.print("Si se sabe el ID del cliente a modificar, escribalo, "
                        + "si no, escriba 0 para imprimir todos los clientes, o -1 para regresar al menu: ");

                while (idfound){
                    opcion = lc.nextInt();
                    lc.nextLine();

                    if(opcion == -1){
                        System.out.println("Regresando a menu...");
                        idfound = false;
                    }

                    else if(opcion == 0){
                        for(int cont = 0; cont < listaClientes.size(); cont++)
                            System.out.println("ID: " + listaClientes.get(cont).getID() +
                                    " Nombre: " + listaClientes.get(cont).getNom());

                        System.out.print("\nDigite el Id del Cliente que quiere modificar: ");
                        idfound = true;
                    }

                    else if(opcion > 0){
                        for(int cont = 0; cont < listaClientes.size(); cont++){
                            if(listaClientes.get(cont).getID() == opcion){
                                listaClientes.get(cont).printCliente();
                                position = cont;

                                System.out.print("\n¿Que quiere modificar?\n"
                                    + "n. Nombre\n"
                                    + "a. Apellido\n"
                                    + "e. Edad\n"
                                    + "Escriba la primera letra de lo que quiere modificar: ");

                                while(sel){
                                    toModify = lc.nextLine();
                                    change = toModify.charAt(0);
                                    switch(change){
                                        case 'N': case 'n':
                                          System.out.println("Escriba el nuevo nombre del cliente: ");
                                          newNom = lc.nextLine();
                                          listaClientes.get(position).setNom(newNom);
                                          sel = false;
                                          break;
                                        case 'A': case 'a':
                                          System.out.println("Escriba los nuevos apellidos del cliente: ");
                                          newAp = lc.nextLine();
                                          listaClientes.get(position).setAp(newAp);
                                          sel = false;
                                          break;
                                        case 'E': case 'e':
                                          System.out.println("Escriba la nueva edad del cliente: ");
                                          newEdad = lc.nextInt();
                                          lc.nextLine();
                                          listaClientes.get(position).setEdad(newEdad);
                                          sel = false;
                                          break;
                                        default:
                                            System.out.print("Opcion no existe, vuelva a intentar: ");
                                            sel = true;
                                            break;
                                    }//fin switch
                                }//fin del while del switch
                            found = true;
                            }

                            if(found)
                                idfound = false;

                            else{
                                System.out.println("No se encontro el Id de ese cliente, intente de nuevo.");
                                idfound = true;
                            }
                        }
                    }

                    else{
                        System.out.println("\nEl Id no existe.");

                        System.out.print("Digite el Id del Cliente que quiere modificar: ");
                        idfound = true;
                    }
                }//fin while idfound
            }//fin try
         // }//fin while
            catch(InputMismatchException ime){
                System.err.println("Error: No se pueden teclear letras. \n");
                lc.nextLine();
            }
        }

        menu();
    }//fin modificar datos cliente

    public static void mDT(){
        Scanner lc = new Scanner(System.in);

        TarjetaCredito tc = new TarjetaCredito();
        String newNum;
        int newMonth, newYear;
        int numTarj;

        int typeCard, id, position = -1;
        boolean idfound = true, selCard, err = true, found = false;

        if(listaClientes.isEmpty())
            System.out.println("\n No hay clientes registrados, regresando al Menu...\n");

        else{
            try{
                System.out.print("Si se sabe el ID del cliente a modificar, escribalo, "
                        + "si no, escriba 0 para imprimir todos los clientes, o -1 para regresar al menu: ");

                while (idfound){
                    id = lc.nextInt();
                    lc.nextLine();

                    if(id == -1){
                        System.out.println("Regresando a menu...");
                        idfound = false;
                    }

                    else if(id == 0){
                        for(int cont = 0; cont < listaClientes.size(); cont++)
                            System.out.println("ID: " + listaClientes.get(cont).getID() +
                                    " Nombre: " + listaClientes.get(cont).getNom());

                        System.out.print("\nDigite el Id del Cliente que quiere modificar: ");
                        idfound = true;
                    }

                    else if(id > 0){
                        for(int cont = 0; cont < listaClientes.size(); cont++){
                            if(listaClientes.get(cont).getID() == id){
                                System.out.println("ID: " + listaClientes.get(cont).getID() +
                                    " Nombre: " + listaClientes.get(cont).getNom());
                                position = cont;
                                found = true;
                            }

                            if(found)
                                idfound = false;

                            else{
                                System.out.println("No se encontro el Id de ese cliente, intente de nuevo.");
                                idfound = true;
                            }
                        }
                    }

                    else{
                        System.out.println("\nEl Id no existe.");

                        System.out.print("Digite el Id del Cliente que quiere modificar: ");
                        idfound = true;
                    }
                }//fin while idfound
            }//fin try
            catch(InputMismatchException ime){
                System.err.println("Error: No se pueden teclear letras. \n");
                lc.nextLine();
            }

            System.out.printf("\nTarjetas actuales de %s: \n",
                    listaClientes.get(position).getNom());

            listaClientes.get(position).printTarjetas();

            System.out.println("Seleccione que tarjeta quiere modificar: ");
            numTarj = lc.nextInt();
            lc.nextLine();

            System.out.println("\n Tajetas Disponibles:\n");

            for (TipoTC t : TipoTC.values())
              System.out.printf("La TIIE de la %s es: %.2f%% %n"
              + "Su Tasa Mensual es: %.2f%% %n"
              + "Su Tasa Anual es: %.2f%% %n"
              + "%n", t, t.TIIE(), t.TIM(), t.TIA());

            System.out.printf("Seleccione la opcion de la tarjeta que desea: %n%n"
            + "1: Clásica: \t\t\t 2: Oro \t\t\t 3: Platinum \t\t\t 4: Black%n"
            + "Ingresos mínimos: $7,500 \t Ingresos mínimos: $15,000\t"
            + " Ingresos mínimos: $45,000\t Ingresos mínimos: $100,000%n"
            + "Anualidad: $699 \t\t Anualidad: $959 \t\t Anualidad:1,999 \t\t Anualidad:4,599 %n%n");

            while(err){
                try{
                    do{
                        System.out.print("Seleccione [1, 2, 3 o 4]: ");
                            typeCard = lc.nextInt();
                            lc.nextLine();

                        if(typeCard > 4 || typeCard < 1){
                            System.out.println("Esa opción no es válida \n");
                            selCard = false;
                        }

                        else{
                            System.out.println("Nuevo numero Tarjeta? [16 Digitos]: ");
                                newNum = lc.nextLine();

                            System.out.println("Fecha de expedicion? [MM AAAA]: ");
                                newMonth = lc.nextInt();
                                newYear = lc.nextInt();

                            System.out.println("Balance: ");
                            //utilizar mismo balance que tenia

                            switch(typeCard){
                              case 1:
                                    tc = new TarjetaCredito(newNum, listaClientes.get(position).getBalanceTarjeta(numTarj), newMonth, newYear, newMonth, (newYear+5), TipoTC.CLASICA);
                                    System.out.println("Su tarjeta Clasica ha quedado registrada.\n");
                                    selCard = true;
                                    break;
                                  case 2:
                                    tc = new TarjetaCredito(newNum, listaClientes.get(position).getBalanceTarjeta(numTarj), newMonth, newYear, newMonth, (newYear+5), TipoTC.ORO);
                                    System.out.println("Su tarjeta Oro ha quedado registrada\n");
                                    selCard = true;
                                    break;
                                  case 3:
                                    tc = new TarjetaCredito(newNum, listaClientes.get(position).getBalanceTarjeta(numTarj), newMonth, newYear, newMonth, (newYear+5), TipoTC.PLATINO);
                                    System.out.println("Su tarjeta Platino ha quedado registrada\n");
                                    selCard = true;
                                    break;
                                  case 4:
                                    tc = new TarjetaCredito(newNum, listaClientes.get(position).getBalanceTarjeta(numTarj), newMonth, newYear, newMonth, (newYear+5), TipoTC.BLACK);
                                    System.out.println("Su tarjeta BLACK ha quedado registrada\n");
                                    selCard = true;
                                    break;
                                  default:
                                    System.out.println("Opcion no valida. Elija entre 1 y 4.\n");
                                    selCard = false;
                                    break;
                                }//switch
                        }//else
                    }while(selCard == false);

                    listaClientes.get(position).removeTarjeta(numTarj);
                    listaClientes.get(position).setTarjetaCredito(tc);
                    err = false;
                }//fin try
                catch (ArithmeticException ex) {
                        System.err.println("Error: Fecha no existe. \n");
                }
                catch (InputMismatchException ime) {
                        System.err.println("Error: No se pueden teclear letras. \n");
                        lc.nextLine();
                }
            }//fin err
        }

        //NO switch que quiere modificar

        //estaTarjeta.actualizaDatos( , , );

        menu();
    }//fin modificar datos tarjeta

    public static void aTCE(){
        Scanner lc = new Scanner(System.in);
        int typeCard, opcion, position = 0;
        boolean selCard, found = false, idfound = true, err = true;

        TarjetaCredito tc = new TarjetaCredito();
        String numero;
        int month, year;
        int balance;

        if(listaClientes.isEmpty())
            System.out.println("\n No hay clientes registrados, regresando al Menu...\n");

        else{
            try{
                System.out.println("Si se sabe el ID del cliente a agregar tarjeta nueva, "
                        + "escribalo, si no, escriba 0 para imprimir todos los clientes, o -1 para regresar al menu.");

                while (idfound){
                    opcion = lc.nextInt();

                    if(opcion == -1){
                        System.out.println("Regresando a menu...");
                        idfound = false;
                    }

                    else if(opcion == 0){
                        for(int cont = 0; cont < listaClientes.size(); cont++)
                            System.out.println("ID: " + listaClientes.get(cont).getID() +
                                    " Nombre: " + listaClientes.get(cont).getNom());

                        System.out.print("\nDigite el Id del Cliente que quiere agregar tarjeta: ");
                        idfound = true;
                    }

                    else if(opcion > 0){
                        for(int cont = 0; cont < listaClientes.size(); cont++){
                            if(listaClientes.get(cont).getID() == opcion){
                                System.out.println("\nID: " + listaClientes.get(cont).getID() +
                                    " Nombre: " + listaClientes.get(cont).getNom());
                                position = cont;
                                found = true;
                            }

                            if(found)
                                idfound = false;

                            else{
                                System.out.println("No se encontro el Id de ese cliente, intente de nuevo.");
                                idfound = true;
                            }
                        }
                    }

                    else{
                        System.out.println("\nEl Id no existe");

                        System.out.print("Digite el Id del Cliente que quiere agregar tarjeta: ");
                        idfound = true;
                    }
                }//fin while idfound
            }//fin try
            catch(InputMismatchException ime){
                System.err.println("Error: No se pueden teclear letras. \n");
                lc.nextLine();
            }

            System.out.println("\n Tajetas Disponibles:\n");

            for (TipoTC t : TipoTC.values())
              System.out.printf("La TIIE de la %s es: %.2f%% %n"
              + "Su Tasa Mensual es: %.2f%% %n"
              + "Su Tasa Anual es: %.2f%% %n"
              + "%n", t, t.TIIE(), t.TIM(), t.TIA());

            System.out.printf("Seleccione la opcion de la tarjeta que desea: %n%n"
            + "1: Clásica: \t\t\t 2: Oro \t\t\t 3: Platinum \t\t\t 4: Black%n"
            + "Ingresos mínimos: $7,500 \t Ingresos mínimos: $15,000\t"
            + " Ingresos mínimos: $45,000\t Ingresos mínimos: $100,000%n"
            + "Anualidad: $699 \t\t Anualidad: $959 \t\t Anualidad:1,999 \t\t Anualidad:4,599 %n%n");

            while(err){
                try{
                    do{
                        System.out.print("Seleccione [1, 2, 3 o 4]: ");
                            typeCard = lc.nextInt();
                            lc.nextLine();

                        if(typeCard > 4 || typeCard < 1){
                            System.out.println("Esa opción no es válida \n");
                            selCard = false;
                        }

                        else{
                            System.out.println("Numero Tarjeta? [16 Digitos]: ");
                                numero = lc.nextLine();

                            System.out.println("Fecha de expedicion? [MM AAAA]: ");
                                month = lc.nextInt();
                                year = lc.nextInt();

                            System.out.println("Balance?: ");
                                balance = lc.nextInt();
                            lc.nextLine();

                            switch(typeCard){
                              case 1:
                                    tc = new TarjetaCredito(numero, balance, month, year, month, (year+5), TipoTC.CLASICA);
                                    System.out.println("Su tarjeta Clasica ha quedado registrada.\n");
                                    selCard = true;
                                    break;
                                  case 2:
                                    tc = new TarjetaCredito(numero, balance, month, year, month, (year+5), TipoTC.ORO);
                                    System.out.println("Su tarjeta Oro ha quedado registrada\n");
                                    selCard = true;
                                    break;
                                  case 3:
                                    tc = new TarjetaCredito(numero, balance, month, year, month, (year+5), TipoTC.PLATINO);
                                    System.out.println("Su tarjeta Platino ha quedado registrada\n");
                                    selCard = true;
                                    break;
                                  case 4:
                                    tc = new TarjetaCredito(numero, balance, month, year, month, (year+5), TipoTC.BLACK);
                                    System.out.println("Su tarjeta BLACK ha quedado registrada\n");
                                    selCard = true;
                                    break;
                                  default:
                                    System.out.println("Opcion no valida. Elija entre 1 y 4.\n");
                                    selCard = false;
                                    break;
                                }//switch
                        }//else
                    }while(selCard == false);

                listaClientes.get(position).setTarjetaCredito(tc);
                err = false;
                }//fin try
                catch (ArithmeticException ex) {
                        System.err.println("Error: Fecha no existe. \n");
                }
                catch (InputMismatchException ime) {
                        System.err.println("Error: No se pueden teclear letras. \n");
                        lc.nextLine();
                }
            }//fin err
        }

        menu();
    }//fin de addTarjeta

    public static void iD(){
        Scanner lc = new Scanner(System.in);
        int id;
        boolean idfound = true, err = true, found = false;

        if(listaClientes.isEmpty()){
            System.out.println("\nNo hay Clientes registrados, regresando al Menu...\n");
        }

        else{
            System.out.println("Si se sabe el ID del cliente a imprimir, escribalo, "
            + "si no, escriba 0 para imprimir todos los clientes, o -1 para regresar a menu.");

            while(err){
                try{
                    while (idfound){
                      id = lc.nextInt();
                      lc.nextLine();

                    if(id == -1){
                        System.out.println("Regresando a menu...\n");
                        idfound = false;
                    }

                    else if(id == 0){
                        for(int cont = 0; cont < listaClientes.size(); cont++)
                            System.out.println("ID: " + listaClientes.get(cont).getID() +
                                    " Nombre: " + listaClientes.get(cont).getNom());

                        System.out.println("\nDigite el Id del Cliente que quiere imprimir: ");
                        idfound = true;
                    }

                    else if(id > 0){
                        for(int cont = 0; cont < listaClientes.size(); cont++){
                            if(listaClientes.get(cont).getID() == id){
                                listaClientes.get(cont).printCliente();
                                found = true;
                            }

                            if(found)
                                idfound = false;

                            else{
                                System.out.println("No se encontro el Id de ese cliente, intente de nuevo.");
                                idfound = true;
                            }
                        }
                    }

                    else{
                        System.out.println("\nEl Id no existe");

                        System.out.print("Digite el Id del Cliente que quiere imprimir: ");
                        idfound = true;
                    }
                  }//fin while idfound
                    err = false;
                }//fin try//fin try
                catch (InputMismatchException ime) {
                        System.err.println("Error: No se pueden teclear letras. \n");
                        lc.nextLine();
                        System.out.print("Digite el Id del Cliente que quiere imprimir: ");
                }
            }//fin err
        }
        menu();
    }//fin imprimir datos

}//fin de la clase
