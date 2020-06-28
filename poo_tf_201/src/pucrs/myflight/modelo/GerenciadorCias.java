package pucrs.myflight.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class GerenciadorCias {

    private Map<String,CiaAerea> empresas;
    Map<String,Set<String>> arquivo;

    private static GerenciadorCias instance;

    public static GerenciadorCias getInstance() {
        if ( instance == null )
            instance = new GerenciadorCias();

        return instance;
    }

    private GerenciadorCias() {
        this.empresas = new HashMap<>();
    }

    public ArrayList<CiaAerea> listarTodas() {
        return new ArrayList<>(empresas.values());
    }

    public void carregaDados(String nomeArq){
        File file = new File(nomeArq);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String arquivo;
            while ((arquivo = br.readLine()) != null) {
              //  System.out.println(arquivo);
                String[] dados = arquivo.split(";");
                CiaAerea nova = new CiaAerea(dados[0], dados[1]);
                adicionar(nova);
            }
        } catch (IOException e) {
            System.err.format("Erro de E/S: %s%n ", e);
        }
    }

    public void adicionar(CiaAerea cia1) {
        empresas.put(cia1.getCodigo(),
                cia1);
    }

    public CiaAerea buscarCodigo(String cod) {
        return empresas.get(cod);
    }

    public CiaAerea buscarNome(String nome) {
        for(CiaAerea cia: empresas.values())
            if(cia.getNome().equals(nome))
                return cia;
        return null;
    }

}
