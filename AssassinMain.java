import java.util.*;
public class AssassinMain {

	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<String>();
		names.add("A");
		names.add("B");
		names.add("C");
		names.add("D");
		names.add("E");
		
		AssassinManager hitman = new AssassinManager(names);
		
		hitman.kill("B");
		hitman.printKillRing();
		
		
		hitman.printGraveyard();
		System.out.println("----------------------------");
		hitman.kill("A");
		hitman.printKillRing();
		hitman.printGraveyard();
		System.out.println("----------------------------");
		hitman.kill("C");
		hitman.printKillRing();
		hitman.printGraveyard();
		System.out.println("----------------------------");
		hitman.kill("D");
		hitman.printKillRing();
		hitman.printGraveyard();
		System.out.println("----------------------------");
		
		String bich = hitman.winner();
		System.out.println(bich);
	}

}
