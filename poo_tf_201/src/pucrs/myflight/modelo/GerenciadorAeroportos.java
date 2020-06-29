package pucrs.myflight.modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GerenciadorAeroportos {

    private ArrayList<Aeroporto> aeroportos;

    public GerenciadorAeroportos() {
        this.aeroportos = new ArrayList<>();
        dadosAeroportos("airports.dat");
    }

    public void ordenarNomes() {
        Collections.sort(aeroportos);
    }

    public void adicionar(Aeroporto aero) {
        aeroportos.add(aero);
    }

    public void dadosAeroportos(String nomeAreoporto) {

        Path path = Paths.get(nomeAreoporto);
        try (BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset())) {
            String header = br.readLine();
            String aeroporto = null;
            while ((aeroporto = br.readLine()) != null) {
                Scanner sc = new Scanner(aeroporto).useDelimiter("-");
                String codigo, nome, codPais;
                double latitude, longitude;
                codigo = sc.next();
                latitude = Double.parseDouble(sc.next());
                longitude = Double.parseDouble(sc.next());
                nome = sc.next();
                codPais = sc.next();
                Geo geo = new Geo(latitude, longitude);

                Aeroporto umAeroporto = new Aeroporto(codigo, nome, geo, codPais);
                this.aeroportos.add(umAeroporto);
            }
        } catch (IOException x) {
            System.err.format("Erro na leitura do arquivo.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Aeroporto> listarTodos() {
        return new ArrayList<>(aeroportos);
    }

    public Aeroporto buscarCodigo(String codigo) {
        for (Aeroporto a : aeroportos)
            if (a.getCodigo().equals(codigo))
                return a;
        return null;
    }

    //aqui temos que inserir as escalas e conexoes dos voos

}


