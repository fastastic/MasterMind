package com.prop.domini;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver3 {
	//Driver clase Algorisme, CodeBreaker i Controlador de Domini

	private static Algorisme algor = null;
	private static Scanner lector;
	
	public static void basic() {
		boolean guanyat =  false;
		Algorisme a = new Algorisme();
		System.out.println("Introdueix el nombre de columnes");
		int columnes = lector.nextInt();
		if(columnes <= 0) {
			System.out.println("El nombre de columnes ha de ser >=1, torna a començar");
			return;
		}
		System.out.println("Introdueix el nombre de colors");
		int colors= lector.nextInt();
		if(colors <= 0) {
			System.out.println("El nombre de colors ha de ser >=1, torna a començar");
			return;
		}
		ArrayList<Integer> resposta = new ArrayList<Integer>();
		ArrayList<Integer> codiproposat = new ArrayList<Integer>();
		int j = 0;
		System.out.println("Introdueix la combinacio a endivinar (el valors dels colors van [0,colors-1]");
		ArrayList<Integer> codisecret = new ArrayList<Integer>();
		for(int i = 0; i < columnes;++i) {
			int numerito = lector.nextInt();
			if(numerito >= colors || numerito < 0) {
				System.out.println("Tots els valors han de ser menors que el numero de colors");
				return;
			}
			codisecret.add(numerito);
		}
		while(!guanyat && j <= 10) {
			System.out.println("Iteracio " + j);
			codiproposat = a.calcula_jugada(columnes,colors, resposta);
			//for(int i = 0; i < codiproposat.size(); ++i) System.out.print(codiproposat.get(i));
			//System.out.println("");
			resposta = a.aplica_logica(codisecret, codiproposat);
			int negres = 0;
			for(int r = 0; r < columnes;++r) 
				if(resposta.get(r) == 2) ++negres;
			guanyat = (negres == columnes);	
			++j;
		}
		if(guanyat) System.out.println("Has encertat");
		else System.out.println("T'has quedat sense intents, torna a començar");
		
	}
	
	public static void five() {
		boolean guanyat2 =  false;
		Algorisme a2 = new Algorisme();
		System.out.println("Introdueix el nombre de columnes");
		int columnes2 = lector.nextInt();
		if(columnes2 <= 0) {
			System.out.println("El nombre de columnes ha de ser >=1, torna a començar");
			return;
		}
		System.out.println("Introdueix el nombre de colors");
		int colors2= lector.nextInt();
		if(colors2 <= 0) {
			System.out.println("El nombre de colors ha de ser >=1, torna a començar");
			return;
		}
		if(columnes2 >=5 && colors2 >= 5) {
			System.out.println("Masses combinacions!");
			return;
		}
		System.out.println("Introdueix la combinacio a endivinar (el valors dels colors van [0,colors-1]");
		ArrayList<Integer> codisecret2 = new ArrayList<Integer>();
		for(int i = 0; i < columnes2;++i) {
			int numerito = lector.nextInt();
			if(numerito >= colors2 || numerito < 0) {
				System.out.println("Tots els valors han de ser menors que el numero de colors");
				return;
			}
			codisecret2.add(numerito);
		}
		
		ArrayList<Integer> resposta2 = new ArrayList<Integer>();
		ArrayList<Integer> codiproposat2 = new ArrayList<Integer>();
		int k = 0;
		while(!guanyat2 && k <= 10) {
			System.out.println("Iteracio " + k);
			codiproposat2 = a2.five_guess(columnes2,colors2, resposta2);
			//for(int s = 0; s < codiproposat2.size(); ++s) System.out.print(codiproposat2.get(s));
			resposta2 = a2.aplica_logica(codisecret2, codiproposat2);
			int negres2 = 0;
			for(int r = 0; r < columnes2;++r) 
				if(resposta2.get(r) == 2) ++negres2;
			guanyat2 = (negres2 == columnes2);	
			++k;
			
		}
		
		if(guanyat2) System.out.println("Has encertat");
		else System.out.println("T'has quedat sense intents, torna a començar");
	}
	
	public static void codebreakerpersona() {
			new CodeBreaker(false);
			System.out.println("Nou CodeBreaker Persona creat correctament");
	}
	
	public static void algorithm() {
		algor = new Algorisme();
		System.out.println("Algorisme creat correctament");
	}
	
	public static void codebreakercpu() {
		if(algor == null) System.out.println("Primer has de crear un algorisme");
		else {
			CodeBreaker c3 = new CodeBreaker(true);
			c3.setalgorisme(algor);
			System.out.println("Nou CodeBreaker Cpu creat correctament");
		}
	}

    public static void codemakercpu() {
    		CodeMaker cMakerCPU = new CodeMaker(true);
	    System.out.println("Nou CodeMaker Cpu creat correctament");
	}

    public static void codemakerpersona() {
    		CodeMaker cMakerPersona = new CodeMaker(false);
		System.out.println("Nou CodeMaker Persona creat correctament");
	}

	public static void main (String args[]) {
		System.out.println("Benvingut a Mastermind! Selecciona una de les següents opcions:");
		System.out.println("0. Surt del driver");
		System.out.println("1. Algorisme basic");
		System.out.println("2. Algorisme five guess");
		System.out.println("3. Crea CodebreakerPersona");
		System.out.println("4. Crear Algorisme");
		System.out.println("5. Crea CodebreakerCpu");
		System.out.println("6. Crea CodemakerCpu");
		System.out.println("7. Crea CodemakerPersona");
		lector = new Scanner(System.in);
		
		char c;
		try{
			while ((c=(char)System.in.read()) != '0' ){
				switch(c) {
					case '1':
						basic();
					break;
					case '2':
						five();
					break;
					case '3':
						codebreakerpersona();
					break;
					case '4':
						algorithm();
					break;
					case '5':
						codebreakercpu();
					break;
					case '6':
						codemakercpu();
					break;
					case '7':
						codemakerpersona();
					break;
				}
			}
		}
		catch (Exception e) {
				e.printStackTrace();
		}
			
	
	}
}
