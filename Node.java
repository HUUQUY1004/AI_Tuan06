package queen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Node {
	public static final int N = 8;
	private Queen[] state;

	public Node() {
		// generateBoard();
		state = new Queen[N];
	}

	public Node(Queen[] state) {
		this.state = new Queen[N];
		for (int i = 0; i < state.length; i++) {
			this.state[i] = new Queen(state[i].getRow(), state[i].getColumn());
		}
	}

	public Node(Node n) {
		this.state = new Queen[N];
		for (int i = 0; i < N; i++) {
			Queen qi = n.state[i];
			this.state[i] = new Queen(qi.getRow(), qi.getColumn());
		}
	}

	public void generateBoard() {
		Random random = new Random();
		for (int i = 0; i < N; i++) {
			state[i] = new Queen(random.nextInt(N), i);
		}
	}

	public int getH() {
		int heuristic = 0;
		// Enter your code here
		for (int i = 0; i < state.length; i++) {
			for (int j = 0; j < state.length; j++) {
				if (i != j) {
					if (state[i].isConflict(state[j])) {
						heuristic += 1;
					}
				}
			}
		}
		return heuristic;
	}

	public List<Node> generateAllCandidates() {
		List<Node> result = new ArrayList<Node>();
		result.add(this);
		// Enter your code here
		for (int i = 0; i < state.length; i++) {
			Node coppy = new Node(this);
			coppy.state[i].move();
			result.add(coppy);
		}
		return result;
	}

	public Node selectNextRandomCandidate() {
		// Enter your code here
		
		return null;
	}

	public void displayBoard() {
		int[][] board = new int[N][N];
		// set queen position on the board
		for (int i = 0; i < N; i++) {
			board[state[i].getRow()][state[i].getColumn()] = 1;
		}
		// print board
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 1) {
					System.out.print("Q" + " ");
				} else {
					System.out.print("-" + " ");
				}
			}
			System.out.println();
		}
	}
	public Node getBestCandidate() {
		List<Node> neighbor = generateAllCandidates();
		int min = Integer.MAX_VALUE;
		Node re = null;
		for (Node node : neighbor) {
			if (node.getH() < min) {
				min = node.getH();
				re = node;
			}
		}
		return re;
	}

}
