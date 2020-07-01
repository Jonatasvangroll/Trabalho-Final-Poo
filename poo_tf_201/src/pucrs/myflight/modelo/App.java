package pucrs.myflight.modelo;

import pucrs.myflight.modelo.TrafegoAeroporto;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class App {

	public static void main(String[] args) {
        //leitura do arquivo "airlines.dat"
		GerenciadorCias gerenciadorCias = new GerenciadorCias();
		System.out.println(gerenciadorCias.listarTodas().size());

        //leitura do arquivo "equipment.dat"
        GerenciadorAeronaves gerenciadorAeronaves = new GerenciadorAeronaves();
        System.out.println(gerenciadorAeronaves.listarTodas().size());
        
        //leitura do arquivo "routes.dat"
        GerenciadorRotas gerenciadorRotas = new GerenciadorRotas();
        System.out.println(gerenciadorRotas.listarTodas().size());
        
        //leitura do arquivo "airports.dat"
        GerenciadorAeroportos gerenciadorAeroportos = new GerenciadorAeroportos();
        System.out.println(gerenciadorAeroportos.listarTodos().size());
        gerenciadorAeroportos.listarAeroportosPorCodCompanhia("2B", gerenciadorRotas);

        //leitura do arquivo "countries.dat"
        GerenciadorPaises gerenciadorPaises = new GerenciadorPaises();
        System.out.println(gerenciadorPaises.listarTodas().size());

        ArrayList<TrafegoAeroporto> ta = gerenciadorAeroportos.estimativaTrafegoPorAeroporto(gerenciadorRotas, "BR");
        System.out.println(ta.size());
	}
}
