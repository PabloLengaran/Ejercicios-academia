package SistemaElectoral;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class SistemaElectoral {
	
	public static void main(String[] args) {
		SistemaElectoral sistemaElectoral = new SistemaElectoral();
		sistemaElectoral.Votacion();
	}
	
	public void Votacion() {
		//Creamos un arrayList y añadimos los nombres. 
		List <String> nombres = new ArrayList<String>();
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
		
		//Creamos un linkedList de Strings y añadimos los nombres del anterior arrayList.
		List <String> linkedList = new LinkedList<String>();
		for (String nombre : nombres) {
			linkedList.add(nombre);
		}
		
		//Fallo!! en linkedList: no es -1, si se pone -1 no coge a los dos Elena.
		//Creamos un arrayList nuevo para guardar el linkedList pero esta vez estará invertido,
		//para ello utilizaremos el ListIterator.
		ArrayList<String> arrayListInvertido = new ArrayList<String>();
		ListIterator<String> listIterator = linkedList.listIterator(linkedList.size());
		while (listIterator.hasPrevious() ) {
			arrayListInvertido.add(listIterator.previous());
		}
		
		//Creamos un hashSet y añadimos los nombres del arrayList invertido.
		Set<CuentaNombres> cuentaNombres = new HashSet<>();
		for (String nombre : arrayListInvertido) {
			cuentaNombres.add(new CuentaNombres(nombre, 0));
		}
		
		//Comprobamos si existe el nombre y en caso de existir se le suma los 
		//votos correspondientes.
		for (CuentaNombres nombreHash : cuentaNombres) {
			int votos = 0;
			for (String nombreList : arrayListInvertido) {
				if (nombreList.equals(nombreHash.getNombre())) {
					votos ++;
				}
			}
		
		//Se actualiza el HashSet con los votos correspondientes de cada uno de los nombres.
		nombreHash.setVotos(votos);
		
			//Comprobar si tienen más de un voto y si es asi ponerlo, si no tienen 
			//más de uno poner 0.
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
			return "Nombre: " + nombre + ", Votos: " + votos + ";";
		}
		
		//Creamos el metodo equals.
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
