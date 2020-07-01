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

    public void dadosAeronaves(String nomeArq){

        Path path2 = Paths.get(nomeArq);
        try (BufferedReader br = Files.newBufferedReader(path2, Charset.defaultCharset()))
        {
            String header = br.readLine();
            String linha = null;
            while((linha = br.readLine()) != null) {
                Scanner sc = new Scanner(linha).useDelimiter("-");
                String codigo, descricao;
                int capacidade;
                codigo = sc.next();
                descricao = sc.next();
                capacidade = Integer.parseInt(sc.next());

                Aeronave aero = new Aeronave(codigo, descricao,capacidade);
                this.avioes.add(aero);
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
        avioes.sort(Comparator.comparing(Aeronave::getDescricao).reversed());
    }
    
    public void ordenarCodigo() {
        avioes.sort( (Aeronave a1, Aeronave a2) ->
            a1.getCodigo().compareTo(a2.getCodigo()));
    }

    public void ordenarCodigoDescricao() {
       // Ordena pelo código
       avioes.sort(Comparator.comparing(Aeronave::getCodigo).
               thenComparing(Aeronave::getDescricao));
    }

 }
