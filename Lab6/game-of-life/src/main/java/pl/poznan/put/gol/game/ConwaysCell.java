package pl.poznan.put.gol.game;

public class ConwaysCell implements Cell {

	protected int i;
	protected int j;

	public ConwaysCell(int i, int j) {
		this.i = i;
		this.j = j;
	}

	@Override
	public Cells neighbors() {
		// TODO implement method ConwaysCell#neighbors()
		Cells cells = new Cells();
		cells.add(new ConwaysCell(i-1,j-1));
		cells.add(new ConwaysCell(i-1,j));
		cells.add(new ConwaysCell(i-1,j+1));
		cells.add(new ConwaysCell(i,j-1));
		cells.add(new ConwaysCell(i,j+1));
		cells.add(new ConwaysCell(i+1,j-1));
		cells.add(new ConwaysCell(i+1,j));
		cells.add(new ConwaysCell(i+1,j+1));
		return cells;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ConwaysCell that = (ConwaysCell) o;

		if (i != that.i) return false;
		return j == that.j;
	}

	@Override
	public int hashCode() {
		int result = i;
		result = 31 * result + j;
		return result;
	}

	@Override
	public boolean inNextGeneration(boolean alive, int numberOfNeighbors) {
		// TODO implement method ConwaysRules#inNextGeneration()
		if(!alive && numberOfNeighbors==3) alive = true;
		else if(alive && (numberOfNeighbors<2 || numberOfNeighbors>3)) alive = false;
		return alive;
	}

	@Override
	public String toString() {
		return "c(" + i + ":" + j + ")";
	}

}
