package grafos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

	class Edge {
	    Node destination;
	    Double weight;

	    public Edge(Node destination, Double weight) {
	        this.destination = destination;
	        this.weight = weight;
	    }
	}

	class Node implements Comparable<Node>{
	    int id;
	    List<Edge> neighbors;
	    public Node previous;
	    public double minDistance = Double.POSITIVE_INFINITY;
	    public double secMinDistance = Double.POSITIVE_INFINITY;

	    public Node(int id) {
	        this.id = id;
	        this.neighbors = new ArrayList<>();
	    }

	    public void addNeighbor(Node neighbor, Double weight) {
	        neighbors.add(new Edge(neighbor, weight));
	    }
	       
	    public String cityId(int id) {
	    	String cityName;
	    	switch (id) {
	    	case 1: cityName="Bombinhas"; break;
	    	case 2: cityName="Porto Belo"; break;
	    	case 3: cityName="Itapema"; break;
	    	case 4: cityName="Balneário Camboriú"; break;
	    	case 5: cityName="Camboriú"; break;
	    	case 6: cityName="Itajaí"; break;
	    	case 7: cityName="Navegantes"; break;
	    	case 8: cityName="Penha"; break;
	    	case 9: cityName="Piçarras"; break;
	    	case 10: cityName="Barra Velha"; break;
	    	case 11: cityName="São João do Itaperiú"; break;
	    	case 12: cityName="Luiz Alvez"; break;
	    	case 13: cityName="Ilhota"; break;
	    	case 14: cityName="Gaspar"; break;
	    	case 15: cityName="Brusque"; break;
	    	case 16: cityName="Botuverá"; break;
	    	case 17: cityName="Guabiruba"; break;
	    	case 18: cityName="Blumenau"; break;
	    	case 19: cityName="Pomerode"; break;
	    	case 20: cityName="Rio dos Cedros"; break;
	    	case 21: cityName="Timbó"; break;
	    	case 22: cityName="Indaial"; break;
	    	case 23: cityName="Ascurra"; break;
	    	case 24: cityName="Rodeio"; break;
	    	case 25: cityName="Benedito Novo"; break;
	    	case 26: cityName="Doutor Pedrinho"; break;
	    	case 27: cityName="Jodé Boiteux"; break;
	    	case 28: cityName="Ibirama"; break;
	    	case 29: cityName="Apiúna"; break;
	    	case 30: cityName="Presidente Nereu"; break;
	    	case 31: cityName="Vidal Ramos"; break;
	    	case 32: cityName="Imbuia"; break;
	    	case 33: cityName="Chapadão do Lajeado"; break;
	    	case 34: cityName="Ituporanga"; break;
	    	case 35: cityName="Aurora"; break;
	    	case 36: cityName="Lontras"; break;
	    	case 37: cityName="Rio do Sul"; break;
	    	case 38: cityName="Presidente Getúlio"; break;
	    	case 39: cityName="Dona Emma"; break;
	    	case 40: cityName="Witmarsum"; break;
	    	case 41: cityName="Vitor Meireles"; break;
	    	case 42: cityName="Rio do Campo"; break;
	    	case 43: cityName="Salete"; break;
	    	case 44: cityName="Taió"; break;
	    	case 45: cityName="Rio do Oeste"; break;
	    	case 46: cityName="Mirim Doce"; break;
	    	case 47: cityName="Pouso Redondo"; break;
	    	case 48: cityName="Braço do Trombudo"; break;
	    	case 49: cityName="Trombudo Central"; break;
	    	case 50: cityName="Laurentino"; break;
	    	case 51: cityName="Agronômica"; break;
	    	case 52: cityName="Agrolândia"; break;
	    	case 53: cityName="Atalanta"; break;
	    	case 54: cityName="Petrolândia"; break;
	    	default: cityName="id invalido";
	    	}
	    	return cityName;
	    }
	    
	    public int cityName(String name) {
	    	int cityId;
	    	switch (name) {
	    	case "Bombinhas": cityId=1; break;
	    	case "Porto Belo": cityId=2; break;
	    	case "Itapema": cityId=3; break;
	    	case "Balneário Camboriú": cityId=4; break;
	    	case "Camboriú": cityId=5; break;
	    	case "Itajaí": cityId=6; break;
	    	case "Navegantes": cityId=7; break;
	    	case "Penha": cityId=8; break;
	    	case "Piçarras": cityId=9; break;
	    	case "Barra Velha": cityId=10; break;
	    	case "São João do Itaperiú": cityId=11; break;
	    	case "Luiz Alvez": cityId=12; break;
	    	case "Ilhota": cityId=13; break;
	    	case "Gaspar": cityId=14; break;
	    	case "Brusque": cityId=15; break;
	    	case "Botuverá": cityId=16; break;
	    	case "Guabiruba": cityId=17; break;
	    	case "Blumenau": cityId=18; break;
	    	case "Pomerode": cityId=19; break;
	    	case "Rio dos Cedros": cityId=20; break;
	    	case "Timbó": cityId=21; break;
	    	case "Indaial": cityId=22; break;
	    	case "Ascurra": cityId=23; break;
	    	case "Rodeio": cityId=24; break;
	    	case "Benedito Novo": cityId=25; break;
	    	case "Doutor Pedrinho": cityId=26; break;
	    	case "Jodé Boiteux": cityId=27; break;
	    	case "Ibirama": cityId=28; break;
	    	case "Apiúna": cityId=29; break;
	    	case "Presidente Nereu": cityId=30; break;
	    	case "Vidal Ramos": cityId=31; break;
	    	case "Imbuia": cityId=32; break;
	    	case "Chapadão do Lajeado": cityId=33; break;
	    	case "Ituporanga": cityId=34; break;
	    	case "Aurora": cityId=35; break;
	    	case "Lontras": cityId=36; break;
	    	case "Rio do Sul": cityId=37; break;
	    	case "Presidente Getúlio": cityId=38; break;
	    	case "Dona Emma": cityId=39; break;
	    	case "Witmarsum": cityId=40; break;
	    	case "Vitor Meireles": cityId=41; break;
	    	case "Rio do Campo": cityId=42; break;
	    	case "Salete": cityId=43; break;
	    	case "Taió": cityId=44; break;
	    	case "Rio do Oeste": cityId=45; break;
	    	case "Mirim Doce": cityId=46; break;
	    	case "Pouso Redondo": cityId=47; break;
	    	case "Braço do Trombudo": cityId=48; break;
	    	case "Trombudo Central": cityId=49; break;
	    	case "Laurentino": cityId=50; break;
	    	case "Agronômica": cityId=51; break;
	    	case "Agrolândia": cityId=52; break;
	    	case "Atalanta": cityId=53; break;
	    	case "Petrolândia": cityId=54; break;
	    	default: cityId=0;
	    	}
	    	return cityId;
	    }

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return 0;
		}
	}

	class Graph {
	    Map<Integer, Node> nodes;

	    public Graph() {
	        nodes = new HashMap<>();
	        for (int i = 1; i <= 54; i++) {
	            nodes.put(i, new Node(i));
	        }
	    }

	    public void addEdge(int from, int to, Double weight) {
	        Node nodeFrom = nodes.get(from);
	        Node nodeTo = nodes.get(to);
	        if (nodeFrom != null && nodeTo != null) {
	            nodeFrom.addNeighbor(nodeTo, weight);
	        }
	    }

	    public void displayEdges() {
	        for (Node node : nodes.values()) {
	            for (Edge edge : node.neighbors) {
	                System.out.println("Nó " + node.id + " para Nó " + edge.destination.id + " com peso " + edge.weight);
	            }
	        }
	    }
	    
	    public void shortestPath(int from) {
	    	Node nodeFrom = nodes.get(from);
	        nodeFrom.minDistance = 0.0;
	        PriorityQueue<Node> nodeQueue = new PriorityQueue<Node>();
	        nodeQueue.add(nodeFrom);
	        
	        while (!nodeQueue.isEmpty()) {
	        	Node n = nodeQueue.poll();
	        	for (Edge e : n.neighbors){
	        		Node n2 = e.destination;
	        		double weight = e.weight;
	        		double distanceThroughN = n.minDistance + weight;
	        		if (distanceThroughN < n2.minDistance) {
	        			nodeQueue.remove(n2);
	        			n2.minDistance = distanceThroughN;
	                    n2.previous = n;
	                    nodeQueue.add(n2);
	        		}
	        	}
	        }
	    }
	    
	    public void getShortestPathTo(int to){
	        Node nodeTo = nodes.get(to);
	    	List<Node> path = new ArrayList<Node>();
	    	int i;
	    	Node n;
	    	System.out.println("____________________________________________________________");
	    	System.out.println("Caminho:");
	        for (n = nodeTo; n != null; n = n.previous) {
	        	i = n.id;
	            path.add(n);
	            System.out.println(n.cityId(i));
	            if(i==2)
	            	System.out.println("Pedágio: BR-101 - Ambos os sentidos: Auto=4,90 | Eixo=4,90 | moto=2,45	desde: 04/08/23");
	        }
	        Collections.reverse(path);
	    }
	}
