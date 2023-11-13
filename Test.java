package queen;


public class Test {
	public static void main(String[] args) {
		Node node = new Node();
		node.generateBoard();
		node.displayBoard();
		System.out.println();
//		for (Node n: node.generateAllCandidates()) {
//			System.out.println();
//			n.displayBoard();
//		}
		
		HillClimbingAlgo climbingSearch = new HillClimbingAlgo();
//		climbingSearch.executeHillClimbingWithRandomRestart(node).displayBoard();
		climbingSearch.execute(node).displayBoard();
	}
}