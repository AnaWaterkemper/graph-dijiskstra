package grafos;

import java.util.ArrayList;
import java.util.List;

public class TouristicCities {
	public List<Integer> beach() {
		List<Integer> l = new ArrayList<Integer>();
			l.add(1);
			l.add(2);
			l.add(3);
			l.add(4);
			l.add(6);
			l.add(7);
			l.add(8);
			l.add(9);
			l.add(10);
		return l;
	}
	
	public List<Integer> valeEuropeu() {
		List<Integer> l = new ArrayList<Integer>();
			l.add(12);
			l.add(16);
			l.add(17);
			l.add(19);
			l.add(20);
			l.add(21);
			l.add(22);
			l.add(23);
			l.add(24);
			l.add(25);
			l.add(26);
			l.add(29);
		return l;
	}
	public void attractions(Graph g) {
			System.out.println(g.nodes.get(4).cityId(4)+" - Complexo Ambiental Cyro Gevaerd"); //Balneário Camboriú
			System.out.println(g.nodes.get(8).cityId(8)+" - Betto Carrero"); //Penha
			System.out.println(g.nodes.get(18).cityId(18)+" - Oktoberfest"); //Blumenau

	}
}
