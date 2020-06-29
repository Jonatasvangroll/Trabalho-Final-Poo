package pucrs.myflight.modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class GerenciadorAeronaves {

    private ArrayList<Aeronave> avioes;

    public GerenciadorAeronaves() {
        this.avioes = new ArrayList<>();
        dadosAeronaves("equipment.dat");
    }

    public void adicionar(Aeronave aviao) {
        avioes.add(aviao);
    }


    public void dadosAeronaves(String nomeAero){

        Path path2 = Paths.get(nomeAero);
        try (BufferedReader br = Files.newBufferedReader(path2, Charset.defaultCharset()))
        {
            String header = br.readLine();
            String aero = null;
            while((aero = br.readLine()) != null) {
                Scanner sc = new Scanner(aero).useDelimiter("-");
                String descricao;
                String codigo;
                int ocupacao;
                codigo = sc.next();
                descricao = sc.next();
                ocupacao = Integer.parseInt(sc.next());

                Aeronave umaAero = new Aeronave(codigo, descricao,ocupacao);
                this.avioes.add(umaAero);
            }
        }
        catch (IOException x) {
            System.err.format("Erro na leitura do arquivo.");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



    public ArrayList<Aeronave> listarTodas() {
        return new ArrayList<>(avioes);
    }

    public Aeronave buscarCodigo(String codigo) {
        for(Aeronave a: avioes)
            if(a.getCodigo().equals(codigo))
                return a;
        return null;
    }

    public void ordenarDescricao() {
        // Usando Comparable<Aeronave> em Aeronave
        //Collections.sort(avioes);

        // Usando expressão lambda
        //avioes.sort( (Aeronave a1, Aeronave a2) ->
        //    a1.getDescricao().compareTo(a2.getDescricao()));

        // Mesma coisa, usando método static da interface Comparator:
        //avioes.sort(Comparator.comparing(a -> a.getDescricao()));

        // Invertendo o critério de comparação com reversed():
        avioes.sort(Comparator.comparing(Aeronave::getDescricao).reversed());
    }

    public void ordenarCodigoDescricao() {
       // Ordenando pelo código e desempatando pela descrição
       avioes.sort(Comparator.comparing(Aeronave::getCodigo).
               thenComparing(Aeronave::getDescricao));
    }

    public void ordenarCodigo() {
        avioes.sort( (Aeronave a1, Aeronave a2) ->
            a1.getCodigo().compareTo(a2.getCodigo()));
    }
}
