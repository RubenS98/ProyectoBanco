public enum TipoDeb {
    ORO(30000, 15000, 1000),
    PLATINO(50000, 25000, 500),
    PREMIUM(80000, 40000, 0);

    private final double limDia, limRet, salMin;

    //CONSTRUCTORES ENUM DEBEN SER PRIVADOS, YA QUE SOLO SE CREAN DENTRO DE ESTA CLASE
    private TipoTC(double limDia, double limRet, double salMin){
    this.limDia = limDia;
    this.limRet = limRet;
    this.salMin = salMin;
    }
}
