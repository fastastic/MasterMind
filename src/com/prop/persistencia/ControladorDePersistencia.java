package com.prop.persistencia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ControladorDePersistencia {
	public static RegistreDatabase regDB;
	public static PartidesDatabase partDB;
	public static RankingDatabase rankDB;
	
	public ControladorDePersistencia() {
		regDB = new RegistreDatabase("RegistreJugadors.txt");
		partDB = new PartidesDatabase("Partides.txt");
		rankDB = new RankingDatabase("RankingJugadors.txt");
		regDB.crearDatabase();
		partDB.crearDatabase();
		rankDB.crearDatabase();
	}
	
	/* Guarda en la BBDD toda la info del jugador pasada por parámetros en el vector info solo si no existía
	 * ese jugador, sino no hace nada */
	public void emmagatzemaJugador(ArrayList<String> info) {
		regDB.emmagatzemaJugador(info);
	}
	
	/* Actualiza el jugador con idJugador info[0] con la información que se le pasa por parámetros */
	public void actualitzaJugador(ArrayList<String> info) {
		regDB.actualitzaJugador(info);
	}
	
	/* Devuelve en una matriz toda la info de todos los jugadores del juego registrados hasta el momento. Cada
	 * fila es la info de cada jugador, idJugador, partidas jugadas y partidas ganadas en ese orden.
	 */
	public ArrayList< ArrayList<String> > getJugadors() {
		return regDB.getJugadors();
	}
	
	/* Guarda en la BBDD toda la info de una partida en concreto, si exístia ya esa partida, se borra la partida
	 * antigua con toda su info y se guarda la info actualizada
	 */
	public void emmagatzemaPartida(ArrayList<String> partida, String idJugador) {
		partDB.emmagatzemaPartida(partida,idJugador);
	}
	
	/* Devuelve los idPartida de las partidas no finalizadas del jugador idJugador */	
	public ArrayList<Integer> partidesNoFinalitzades(String idJugador) {
		return partDB.partidesNoFinalitzades(idJugador);
	}
	
	/* Devuelve los idPartida de todas las partidas guardadas del jugador idJugador */
	public ArrayList<String> getIdPartidesGuardades(String idJugador) {
		return partDB.getIdPartidesGuardades(idJugador);
	}
	
	/* Devuelve la info de la partida idPartida a partir del parámetro idPartida que le pasamos */
	public ArrayList<String> getInfoPartida(String idPartida) {
		return partDB.getInfoPartida(idPartida);
	}
	
	/* Deprecated */
	public List< List<String> > obtePartidesJugador(String idJugador) {
		List< List<String> > l = new ArrayList< List<String> >();
		return l;
	}
	
	/* Guarda en la BBDD el ranking pasado por parámetro, una posición del array por línea */
	public void emmagatzemaRanking(ArrayList<String> ranking) {
		rankDB.emmagatzemaRanking(ranking);
	}
	
	/* Devuelve en un arraylist el ranking a partir de la BBDD en el mismo formato que se le pasa cuando se quiere
	 * almacenar
	 */
	public ArrayList<String> obteRanking() {
		return rankDB.obteRanking();
	}
	
	/*
	public static void main(String[] args) {
		ControladorDePersistencia cP = new ControladorDePersistencia();
		String id = "idJugador1";
		String id2 = "idJugador2";
		String id3 = "idJugador3";
		ArrayList<String> s = new ArrayList<>(
				Arrays.asList("idJugador3", "123", "1"));
		ArrayList<String> s2 = new ArrayList<>(
				Arrays.asList("idJugador2", "2", "2"));
		ArrayList<String> s3 = new ArrayList<>(
				Arrays.asList("idJugador3", "3", "3"));
		
		//regDB.emmagatzemaJugador(s3);
		//regDB.actualitzaJugador(s);
		/*
		ArrayList<String> s = new ArrayList<>(
				Arrays.asList("1", "mode1", "temps1", "numJugades1", "puntuacio1", 
						"numFiles1", "longCodi1", "false", "dificultat1", "jugades1", 
						"codiAmagat1", "guanyada1"));
		ArrayList<String> s2 = new ArrayList<>(
				Arrays.asList("2", "mode2", "temps2", "numJugades2", "puntuacio2", 
						"numFiles2", "longCodi2", "false", "dificultat2", "jugades2", 
						"codiAmagat2", "guanyada2"));
		ArrayList<String> s3 = new ArrayList<>(
				Arrays.asList("3", "mode3", "temps3", "numJugades3", "puntuacio3", 
						"numFiles3", "longCodi3", "false", "dificultat3", "jugades3", 
						"codiAmagat3", "guanyada3"));
		cP.emmagatzemaPartida(s3, id3);
		/*ArrayList<String> l = cP.getIdPartidesGuardades("idJugador1");
		for (int i=0; i<l.size(); i++) {
			System.out.println(l.get(i));
		}*/
		/*ArrayList<String> l = cP.getInfoPartida("1");
		for (int i=0; i<l.size(); i++) {
			System.out.println(l.get(i));
		}*/
		//ArrayList<String> l =  new ArrayList<String>(
		//	    Arrays.asList("Juanito 100", "Manolito 200", "Pepito 300"));
		//l = getIdPartidesGuardades(id);
		/*
		for (int i=0; i<l.size(); i++) {
			System.out.print(l.get(i) + " ");
		}
		
		//ArrayList<String> l = new ArrayList<>(Arrays.asList("idjugador2", "5", "6"));
		ArrayList< ArrayList<String> > jugadors = cP.getJugadors();
		for (int i=0; i<jugadors.size(); i++) {
			for (int j=0; j<jugadors.get(0).size(); j++) {
				System.out.println(jugadors.get(i).get(j) +" ");
			}
			System.out.println(" ");
		} 
		
		
	} */
}
