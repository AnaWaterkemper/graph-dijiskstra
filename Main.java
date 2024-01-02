package grafos;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;


public class Main {
	    public static void main(String[] args){
	       Graph g = new Graph();
	       g = mapDB();
	       menu(g);
	    }
	    
	    
	    public static void menu(Graph g) {
	    	int choice1;
	    	Scanner le = new Scanner(System.in);
	    	System.out.println("1- Calcular distância entre cidades");
	    	System.out.println("2- Cidades turísticas");
	    	System.out.println("3- Lista de cidades");
	    	System.out.println("____________________________________________________________");
	    	choice1 = le.nextInt();
	    	
	    	switch(choice1) {
	    	case 1:
	    		int start;
	    		String lstart;
	    		int end;
	    		String lend;
	    		int vehicle;
	    		Node node = g.nodes.get(1);
	    		
	    		System.out.println("Tipo do veiculo: ");
	    		System.out.println("1 - Carro | 2 - Moto | 3 - Ônibus ou caminhão");
	    		vehicle = le.nextInt();
	    			if(vehicle==1) vehicle = 60;
	    			else if(vehicle==2) vehicle = 50;
	    			else if(vehicle==3) vehicle = 40;
	    			else {
	    				System.out.println("Veiculo inválido.");
	    				System.out.println("Calculando média padrão de carro.");
	    				vehicle = 60;
	    			}
	    		Scanner le2 = new Scanner(System.in);
	    	    System.out.println("____________________________________________________________");
	    		System.out.println("Cidade Inicial: ");
	    		lstart = le2.nextLine();
	 	       	start = node.cityName(lstart);
	 	       	if(start<1 || start>54) System.out.println("Cidade não existe. Cheque a gramática, considere acentos e espaços.");
	 	       	Node nstart = g.nodes.get(start);
	 	       	System.out.println("Cidade Final: ");
	 	       	lend = le2.nextLine();
	 	       	end = node.cityName(lend);
	 	       	if(start<1 || start>54) System.out.println("Cidade não existe. Cheque a gramática, considere acentos e espaços.");
	    	    System.out.println("____________________________________________________________");
	 	       	Node nend = g.nodes.get(end);
	 	       	System.out.println("De: "+nstart.cityId(start)+" |Para: "+nend.cityId(end));
	 	       	if(start>end) {
	 	       	int tempInt = start;
 	       		start=end;
 	       		end=tempInt;
 	       		Node tempNode = nstart;
	       		nstart=nend;
	       		nend=tempNode;
	 	       	}
	 	       	g.shortestPath(start);
	 	       	NumberFormat formatter = new DecimalFormat("#0.00");
	 	       	System.out.println("Distancia: " +formatter.format(nend.minDistance)+ "Km");
	 	       	g.getShortestPathTo(end);
	 	       	System.out.println("____________________________________________________________");
	 	       	double d = nend.minDistance;
	 	       	timeMath(d,vehicle);
	 	       	fuel(d, vehicle, formatter);
	 	       	if (d>150.0) { //Uma parada a cada 150Km
	 	       		double food = (d/150)*2;
	 	       	System.out.println("Valor da refeiçã0: R$" +formatter.format(food*20.00));
	 	       	}
	 	       System.out.println("____________________________________________________________");
	 	       	le2.close();
	 	       	break;
	    	case 2:
	    			TouristicCities tc = new TouristicCities();
	    			System.out.println("Praias: ");
		    		for(int i=0;i<=g.nodes.size();i++) {
		    			if(tc.beach().contains(i))
		    				System.out.println(g.nodes.get(i).cityId(i));
		    		}
		    		System.out.println("____________________________________________________________");
	    			System.out.println("Cidades do Vale Europeu: ");
		    		for(int i=1;i<=g.nodes.size();i++) {
		    			if(tc.valeEuropeu().contains(i))
		    				System.out.println(g.nodes.get(i).cityId(i));
		    		}
		    		System.out.println("____________________________________________________________");
	    			System.out.println("Parques e outras atracoes: ");
	    			tc.attractions(g);
	    		break;
	    	case 3:
	    		for(int i=1;i<=g.nodes.size();i++) {
	    			System.out.println(i + " - " + g.nodes.get(i).cityId(i));
	    		}
	    		break;
	    	}
	    	le.close();
	    }
	    
	    public static Graph mapDB() {
			// TODO Auto-generated method stub
	    	 Graph graph = new Graph();

		     //Bombinhas - Praia
	    	 graph.addEdge(1, 2, 10.1);
	    	 //Porto Belo - Praia
	         graph.addEdge(2, 3, 12.5); //Pedágio
	         //Itapema - Praia
	         graph.addEdge(3, 4, 12.8);
	         graph.addEdge(3, 5, 16.3);
	         //Balneário Camboriú - Praia e Complexo Ambiental Cyro Gevaerd
	         graph.addEdge(4, 5, 4.2);
	         graph.addEdge(4, 6, 16.5);
	         //Camboriú
	         graph.addEdge(5, 6, 17.3);
	         graph.addEdge(5, 15, 43.7);
	         //Itajaí - Praia
	         graph.addEdge(6, 7, 4.0);
	         graph.addEdge(6, 13, 19.9);
	         graph.addEdge(6, 14, 43.4);
	         graph.addEdge(6, 15, 35.0);
	         //Navegantes - Praia
	         graph.addEdge(7, 8, 21.1);
	         graph.addEdge(7, 9, 19.1);
	         graph.addEdge(7, 13, 27.8);
	         //Penha - Beto Carrero e Praia
	         graph.addEdge(8, 9, 4.9);
	         //Piçarras - Praia
	         graph.addEdge(9, 10, 25.2);
	         //Barra Velha - Praia
	         graph.addEdge(10, 11, 9.3);
	         graph.addEdge(10, 12, 36.8);
	         //São João do Itaperiú
	         graph.addEdge(11, 12, 25.4);
	         //Luiz Alves - Vale Europeu
	         graph.addEdge(12, 13, 41.1);
	         graph.addEdge(12, 14, 52.7);
	         //Ilhota
	         graph.addEdge(13, 14, 16.8);
	         //Gaspar
	         graph.addEdge(14, 15, 26.8);
	         graph.addEdge(14, 17, 31.1);
	         graph.addEdge(14, 18, 16.5);
	         //Brusque
	         graph.addEdge(15, 16, 22.6);
	         graph.addEdge(15, 17, 8.3);
	         //Botuverá - Vale Europeu
	         graph.addEdge(16, 17, 25.8);
	         graph.addEdge(16, 22, 88.4);
	         graph.addEdge(16, 30, 58.2);
	         graph.addEdge(16, 31, 54.7);
	         //Guabiruba - Vale Europeu
	         graph.addEdge(17, 18, 29.8);
	         //Blumenau - Octoberfest
	         graph.addEdge(18, 19, 29.1);
	         graph.addEdge(18, 22, 24.4);
	         //Pomerode - Vale Europeu
	         graph.addEdge(19, 20, 16.8);
	         graph.addEdge(19, 21, 19.4);
	         //Rio dos Cedros - Vale Europeu
	         graph.addEdge(20, 21, 11.7);
	         graph.addEdge(20, 25, 22.1);
	         graph.addEdge(20, 26, 42.1);
	         //Timbó - Vale Europeu
	         graph.addEdge(21, 22, 11.2);
	         graph.addEdge(21, 24, 17.0);
	         graph.addEdge(21, 25, 16.0);
	         //Indaial - Vale Europeu
	         graph.addEdge(22, 23, 20.0);
	         graph.addEdge(22, 24, 22.7);
	         graph.addEdge(22, 29, 31.25);
	         graph.addEdge(22, 30, 95.1);
	         //Ascurra - Vale Europeu
	         graph.addEdge(23, 24, 4.6);
	         graph.addEdge(23, 25, 29.6);
	         graph.addEdge(23, 28, 32.4);
	         graph.addEdge(23, 29, 9.9);
	         //Rodeio - Vale Europeu
	         graph.addEdge(24, 25, 25.1);
	         //Benedito Novo - Vale Europeu
	         graph.addEdge(25, 26, 21.4);
	         graph.addEdge(25, 27, 82.4);
	         graph.addEdge(25, 28, 62.1);
	         //Doutor Pedrinho - Vale Europeu
	         graph.addEdge(26, 27, 96.3);
	         //Jodé Boiteux
	         graph.addEdge(27, 28, 20.5);
	         graph.addEdge(27, 38, 16.2);
	         graph.addEdge(27, 39, 17.9);
	         graph.addEdge(27, 40, 25.4);
	         graph.addEdge(27, 41, 24.5);
	         //Ibirama
	         graph.addEdge(28, 29, 22.5);
	         graph.addEdge(28, 36, 18.1);
	         graph.addEdge(28, 37, 27.6);
	         graph.addEdge(28, 38, 12.6);
	         //Apiúna - Vale Europeu
	         graph.addEdge(29, 30, 64.0);
	         graph.addEdge(29, 36, 35.2);
	         //Presidente Nereu
	         graph.addEdge(30, 31, 21.1);
	         graph.addEdge(30, 34, 0.95);
	         graph.addEdge(30, 36, 29.1);
	         //Vidal Ramos
	         graph.addEdge(31, 32, 19.8);
	         //Imbuia
	         graph.addEdge(32, 33, 25.3); // passa por fora do Vale do Itajaí
	         graph.addEdge(32, 34, 25.6);
	         //Chapadão do Lajeado
	         graph.addEdge(33, 34, 27.0);
	         graph.addEdge(33, 54, 42.9);
	         //Ituporanga
	         graph.addEdge(34, 35, 13.9);
	         graph.addEdge(34, 53, 21.9);
	         graph.addEdge(34, 54, 19.0);
	         //Aurora
	         graph.addEdge(35, 36, 26.0);
	         graph.addEdge(35, 37, 13.6);
	         graph.addEdge(35, 51, 22.4);
	         //Lontras
	         graph.addEdge(36, 37, 13.0);
	         //Rio do Sul
	         graph.addEdge(37, 38, 38.5);
	         graph.addEdge(37, 50, 13.3);
	         graph.addEdge(37, 51, 10.4);
	         //Presidente Getúlio
	         graph.addEdge(38, 39, 16.1);
	         graph.addEdge(38, 45, 37.5);
	         //Dona Emma
	         graph.addEdge(39, 40, 20.6);
	         graph.addEdge(39, 44, 41.2);
	         graph.addEdge(39, 45, 52.4);
	         //Witmarsum
	         graph.addEdge(40, 41, 10.8);
	         graph.addEdge(40, 43, 24.6);
	         //Vitor Meireles
	         graph.addEdge(41, 42, 43.0);
	         graph.addEdge(41, 43, 35.4);
	         //Rio do Campo
	         graph.addEdge(42, 43, 20.0);
	         graph.addEdge(42, 44, 37.6);
	         //Salete
	         graph.addEdge(43, 44, 19.0);
	         //Taió
	         graph.addEdge(44, 45, 32.3);
	         graph.addEdge(44, 46, 12.9);
	         graph.addEdge(44, 47, 19.4);
	         //Rio do Oeste
	         graph.addEdge(45, 47, 20.5);
	         graph.addEdge(45, 49, 20.4);
	         graph.addEdge(45, 50, 13.3);
	         //Mirim Doce
	         graph.addEdge(46, 47, 19.9);
	         //Pouso Redondo
	         graph.addEdge(47, 48, 18.5);
	         graph.addEdge(47, 49, 18.5);
	         //Braço do Trombudo
	         graph.addEdge(48, 49, 14.4);
	         graph.addEdge(48, 49, 13.5);
	         //Trombudo Central
	         graph.addEdge(49, 51, 11.6);
	         graph.addEdge(49, 52, 13.5);
	         //Laurentino
	         graph.addEdge(50, 51, 8.9);
	         //Agronômica
	         graph.addEdge(51, 52, 25.5);
	         graph.addEdge(51, 53, 31.6);
	         //Agrolândia
	         graph.addEdge(52, 53, 6.1);
	         graph.addEdge(52, 54, 27.6);
	         //Atalanta
	         graph.addEdge(53, 54, 21.5);
	         //Petrolândia
	         graph.addEdge(54, 53, 21.5);
		     
	         return graph;
		}
	    

	    public static void timeMath(double num, int vehicle) {
	    	double hr = num/vehicle;
	    	double day = hr/24;
	    	
	    	int dayfinal = (int) day;
	    	double var = day - dayfinal;
	    	var = var*24.0;
	    	int hrfinal = (int) var;
	    	var = var - hrfinal;
	    	var = var*60.0;
	    	int minfinal = (int) var;
	    	
	    	
	    	
	    	System.out.println("Tempo medio - "  +dayfinal+ " dia(s)>");
	    	if(hrfinal<10 && minfinal<10) {
	    		System.out.println("0" +hrfinal+ ":0" +minfinal);
	    	}else if(hrfinal<10) {
	    		System.out.println("0" +hrfinal+ ":" +minfinal);
	    	}else if(minfinal<10) {
	    		System.out.println(hrfinal+ ":0" +minfinal);
	    	}else {
	    	System.out.println(hrfinal+ ":" +minfinal);
	    	}
	    }
	    
	    
	    public static void fuel(double d, int vehicle, NumberFormat formatter) {
	    	if(vehicle==60)
	    		System.out.println("Consumo medio de gasolina: " + formatter.format(d/10) + " litro(s) | " + (formatter.format((d/10)*5.60))+ " Reais");
	    	if(vehicle==50)
	    		System.out.println("Consumo medio de gasolina: " + formatter.format(d/40) + " litro(s) | " + (formatter.format((d/40)*5.60))+ " Reais");
	    	if(vehicle==40)
	    		System.out.println("Consumo medio de diesel: " + formatter.format(d/3) + " litro(s) | " + (formatter.format((d/3)*6.10))+ " Reais");
	    }
	}
