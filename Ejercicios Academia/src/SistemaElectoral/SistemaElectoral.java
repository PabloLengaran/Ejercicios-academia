package SistemaElectoral;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Set;

public class SistemaElectoral {
	
	public static void main(String[] args) {
		SistemaElectoral sistemaElectoral = new SistemaElectoral();
		sistemaElectoral.Votacion();
	}
	
	public void Votacion() {
		ArrayList<String> nombres = new ArrayList<String>();
		nombres.add("Luis");
		nombres.add("Maria");
		nombres.add("Andoni");
		nombres.add("Isabel");
		nombres.add("Asier");
		nombres.add("Luis");
		nombres.add("Andoni");
		nombres.add("Carlos");
		nombres.add("Luis");
		nombres.add("Luis");
		nombres.add("Aitziber");
		nombres.add("Elena");
		nombres.add("Elena");
		
		LinkedList<String> linkedList = new LinkedList<String>();
		for (String nombre : nombres) {
			linkedList.add(nombre);
		}
		
		//fallo en linkedList: no es -1, si se pone -1 no coge a las dos Elenas.
		ArrayList<String> arrayListInvertido = new ArrayList<String>();
		ListIterator<String> listIterator = linkedList.listIterator(linkedList.size());
		while (listIterator.hasPrevious() ) {
			arrayListInvertido.add(listIterator.previous());
		}
		
		Set<CuentaNombres> cuentaNombres = new HashSet<>();
		for (String nombre : arrayListInvertido) {
			cuentaNombres.add(new CuentaNombres(nombre, 0));
		}
		
		for (CuentaNombres nombreHash : cuentaNombres) {
			int votos = 0;
			for (String nombreList : arrayListInvertido) {
				if (nombreList.equals(nombreHash.getNombre())) {
					votos ++;
				}
			}
			
			nombreHash.setVotos(votos);
			
			if (nombreHash.getVotos() > 1){
				nombreHash.setVotos(votos);
			} else {
				nombreHash.setVotos(0);
			}
			
			
		}
		
		System.out.println(cuentaNombres);
	}
	
	private class CuentaNombres{
		
		private String nombre;
		private int votos;
		
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public int getVotos() {
			return votos;
		}
		public void setVotos(int votos) {
			this.votos = votos;
		}
		
		public CuentaNombres(String nombre, int votos) {
			super();
			this.nombre = nombre;
			this.votos = votos;
		}
		
		@Override
		public String toString() {
			return "Nombre: " + nombre + ", Votos: " + votos + ";" + "\n";
		}
		
		public boolean equals (Object obj) {
			if (obj instanceof CuentaNombres) {
				CuentaNombres cn = (CuentaNombres) obj;
				return this.nombre.equals(cn.nombre);
			}
			return false;
		}
		
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return nombre.hashCode();
		}
	}
}
