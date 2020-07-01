package pucrs.myflight.modelo;

import pucrs.myflight.modelo.models.TrafegoAeroporto;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class App {

	public static void main(String[] args) {

		//TESTE LEITURA DE DADOS DO ARQUIVO EQUIPMENT.DAT
	    GerenciadorAeronaves gerenciadorAeronaves = new GerenciadorAeronaves();
        System.out.println(gerenciadorAeronaves.listarTodas().size());

        //TESTE LEITURA DE DADOS DO ARQUIVO AIRLINES.DAT
		GerenciadorCias gerenciadorCias = new GerenciadorCias();
		System.out.println(gerenciadorCias.listarTodas().size());

        //TESTE LEITURA DE DADOS DO ARQUIVO COUNTRIES.DAT
        GerenciadorPaises gerenciadorPaises = new GerenciadorPaises();
        System.out.println(gerenciadorPaises.listarTodas().size());

        //TESTE LEITURA DE DADOS DO ARQUIVO AIRPORTS.DAT
        GerenciadorAeroportos gerenciadorAeroportos = new GerenciadorAeroportos();
        System.out.println(gerenciadorAeroportos.listarTodos().size());

        //TESTE LEITURA DE DADOS DO ARQUIVO ROUTES.DAT
        GerenciadorRotas gerenciadorRotas = new GerenciadorRotas();
        System.out.println(gerenciadorRotas.listarTodas().size());

        gerenciadorAeroportos.listarAeroportosPorCodCompanhia("2B", gerenciadorRotas);

        ArrayList<TrafegoAeroporto> ta = gerenciadorAeroportos.estimativaTrafegoPorAeroporto(gerenciadorRotas, "BR");

        System.out.println(ta.size());

	}
}
