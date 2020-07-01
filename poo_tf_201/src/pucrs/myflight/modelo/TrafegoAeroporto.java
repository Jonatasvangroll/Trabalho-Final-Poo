package pucrs.myflight.modelo;

import pucrs.myflight.modelo.Aeroporto;

public class TrafegoAeroporto {
    int numeroDeRotas;
    Aeroporto aeroporto;
   

    public TrafegoAeroporto(Aeroporto aero, int numRotas) {
        this.numeroDeRotas = numRotas;
        this.aeroporto = aero;
    }
    public int getNumeroDeRotas() { return this.numeroDeRotas; }
    public Aeroporto getAeroporto() { return this.aeroporto; }
}
