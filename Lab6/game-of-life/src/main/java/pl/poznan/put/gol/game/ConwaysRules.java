package pl.poznan.put.gol.game;

public class ConwaysRules implements Rules {

	@Override
	public boolean inNextGeneration(boolean alive, int numberOfNeighbors) {
		// TODO implement method ConwaysRules#inNextGeneration()
		if(!alive && numberOfNeighbors==3) alive = true;
		else if(alive && (numberOfNeighbors<2 || numberOfNeighbors>3)) alive = false;
		return alive;
	}

}
