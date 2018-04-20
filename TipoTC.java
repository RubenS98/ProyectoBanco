public enum TipoTC {
    CLASICA(7500, 699, 29, 47),
    ORO(15000, 959, 25, 45),
    PLATINO(45000, 1999, 16, 33),
    BLACK(100000, 4599, 9.9, 26);

    private final double ingresosMin, anualidad, min, max;

    private static final int corte = 28;

    //CONSTRUCTORES ENUM DEBEN SER PRIVADOS, YA QUE SOLO SE CREAN DENTRO DE ESTA CLASE
    private TipoTC(double ingresosMin, double anualidad, double min, double max){
    this.ingresosMin = ingresosMin;
    this.anualidad = anualidad;
    this.min = min;
    this. max = max;
    }

    public double TIIE(){
        double tiie = (corte*100)/360;
        return tiie;
    }

    public double TIA(){
        double tia = TIIE() + (max-min);

        return tia;
    }

    public double TIM(){
        double tim = (TIA()/360) * 30;

        return tim;
    }
}
