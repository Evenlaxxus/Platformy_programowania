package pl.poznan.put.gol.game;

public class Generation {

	private Rules rules;
	private Cells aliveCells;

	public Generation(Rules rules, Cell... aliveCells) {
		this(rules, new Cells(aliveCells));
	}

	public Generation(Rules rules, Cells aliveCells) {
		this.rules = rules;
		this.aliveCells = aliveCells;
	}

	public void evolve() {
		// TODO implement method Generation#evolve()
		Cells new_alive = new Cells();
		for(Cell cell: this.aliveCells){
			for(Cell neighbour: cell.neighbors()){
				if(neighbour.inNextGeneration(this.aliveCells.contains(neighbour),this.countAliveNeighbors(neighbour))){
					new_alive.add(neighbour);
				}
			}
			if(cell.inNextGeneration(this.aliveCells.contains(cell),this.countAliveNeighbors(cell))){
				new_alive.add(cell);
			}
		}

		this.aliveCells=new_alive;
	}

	public boolean isAlive(Cell cell) {
		// TODO implement method Generation#isAlive()
		return this.aliveCells.contains(cell);
	}

	public int countAliveNeighbors(Cell cell) {
		// TODO implement method Generation#countAliveNeighbors()
		Cells cells = cell.neighbors();
		int i = 0;
		for(Cell c: cells){
			if(this.aliveCells.contains(c))i++;
		}
		return i;
	}

	public boolean extinct() {
		return aliveCells.isEmpty();
	}

	public Cells getAliveCells() {
		return aliveCells;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Generation)) {
			return false;
		}
		Generation other = (Generation) obj;
		return aliveCells.equals(other.aliveCells);
	}
}
