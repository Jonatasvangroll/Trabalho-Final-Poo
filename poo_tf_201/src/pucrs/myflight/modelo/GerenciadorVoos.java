package pucrs.myflight.modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;

public class GerenciadorVoos {

    private ArrayList<Voo> voos;

    public GerenciadorVoos() {
        this.voos = new ArrayList<>();
    }

    public void ordenaDataHora() {
       voos.sort(Comparator.comparing(Voo::getDatahora));
    }

    public void ordenaDataHoraDuracao() {
        voos.sort(Comparator.comparing(Voo::getDatahora).
                thenComparing(Voo::getDuracao));
    }

    public void adiciona(Voo r) {
        voos.add(r);
    }

    public ArrayList<Voo> listaTodos() {
        return new ArrayList<>(voos);
    }

    public ArrayList<Voo> buscaData(LocalDate data) {
       ArrayList<Voo> result = new ArrayList<>();
       for(Voo v: voos)
           if(v.getDatahora().toLocalDate().equals(data))
               result.add(v);
       return result;
    }

    public ArrayList<Voo> buscarOrigem(String cod) {
        ArrayList<Voo> result = new ArrayList<>();
        for(Voo v: voos)
            if(v.getRota().getOrigem().getCodigo().equals(cod))
                result.add(v);
        return result;
    }

    public ArrayList<Voo> buscarPeriodo(LocalTime inicio, LocalTime fim) {
        ArrayList<Voo> result = new ArrayList<>();
        for(Voo v: voos) {
            if(v.getDatahora().toLocalTime().compareTo(inicio) >= 0 &&
                    v.getDatahora().toLocalTime().compareTo(fim) <= 0)
                result.add(v);
        }
        return result;
    }
}
