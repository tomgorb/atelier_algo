import java.util.*;
import java.io.*;


class Case{		
	public int number;  		//le numero du cas a resoudre
	public int cells;		//le nombre de cellules
	public int[] prisoners;		//les prisoniers a liberer

	public Case(int number, int cells, int[] prisoners){
		this.number = number;
		this.cells = cells;
		this.prisoners = prisoners;
	}
}

class BribeThePrisoners{

	public static LinkedList<int[]> generate_permutations(int[] prisoners){
		LinkedList<int[]> permutations = new LinkedList<int[]>();
		int[] new_prisoners;
		int[] new_permutation;
		if (prisoners.length == 1){
			permutations.add(prisoners);
		}
		else{
			for(int prisonerToFree=0; prisonerToFree<prisoners.length; prisonerToFree++){
				new_prisoners = new int[prisoners.length - 1];
				for (int j=0; j<prisonerToFree; j++){
					new_prisoners[j] = prisoners[j];
				}
				for (int j=prisonerToFree+1; j<prisoners.length; j++){
					new_prisoners[j - 1] = prisoners[j];
				}
				for (int[] permutation: generate_permutations(new_prisoners)){
					new_permutation = new int[prisoners.length];
					new_permutation[0] = prisoners[prisonerToFree];
					for(int k=1; k<permutation.length + 1; k++){
						new_permutation[k] = permutation[k - 1];
					}
					permutations.add(new_permutation);
				}
			}
		}
		return permutations;
	}

	public static int solve(Case case_){
		// ######################################################
		// ######################################################
		//FILL ME !! :)
		// ######################################################
		// ######################################################
	}

	public static LinkedList<Case> loadCases() throws FileNotFoundException{
		Scanner scan = new Scanner(new File("/home/fbossiere/Dropbox/algorithms/google_jam/BribeThePrisoners/C-small-practice.in"));
		LinkedList<Case> cases = new LinkedList<Case>();
		String[] temp;
		int n = Integer.parseInt(scan.nextLine());
		int cells = -1;
		int[] prisoners;
		int i = 1;
		while(scan.hasNextLine()){
			temp = scan.nextLine().split(" ");
			if (i%2 == 1){
				cells = Integer.parseInt(temp[0]);
			}
			else {
				prisoners = new int[temp.length];
				for(int j=0; j<temp.length; j++){
					prisoners[j] = Integer.parseInt(temp[j]);
				}
				cases.add(new Case(i/2, cells, prisoners));			
			}
			i++;
		}
		return cases;
	}
	
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException{
		LinkedList<Case> cases = BribeThePrisoners.loadCases();
		int res;
		PrintWriter writer = new PrintWriter("/home/fbossiere/Dropbox/algorithms/google_jam/BribeThePrisoners/C-small-practice-java.out", "UTF-8");
		for (Case case_: cases){
			res = solve(case_);
			writer.println("Case #" + case_.number + ": " + res);
		}
		writer.close();	
	}
}






