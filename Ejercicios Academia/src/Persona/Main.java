package Persona;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona p1 = new Persona("777777", "Igor", 58);
		Persona p2 = new Persona("888888", "Potxo", 21);
		Persona p3 = new Persona("999999", "Erik", 19);
		Persona p4 = new Persona("777777", "Dani", 20);
		ArrayList<Persona> personas = new ArrayList<Persona>();
		personas.add(p1);
		personas.add(p2);
		personas.add(p3);
		personas.add(p4);
		
		System.out.println("Datos ArrayList:");
		for (Persona persona : personas) {
			System.out.println(persona);
		}
		
		Set<Persona> personasSet = new HashSet<Persona>();
		personasSet.add(p1);
		personasSet.add(p2);
		personasSet.add(p3);
		personasSet.add(p4);
		
		
		System.out.println("Datos HashSet:");
		for (Persona persona : personasSet) {
			System.out.println(persona);
		}
	}
	
	

}
