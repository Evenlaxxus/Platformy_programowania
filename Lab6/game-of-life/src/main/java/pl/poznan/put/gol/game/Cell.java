package pl.poznan.put.gol.game;

public interface Cell {

	public Cells neighbors();
	public boolean inNextGeneration(boolean alive, int numberOfNeighbors);

}
