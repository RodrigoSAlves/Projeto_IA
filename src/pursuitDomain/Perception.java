package pursuitDomain;

public class Perception {

	private Position prayPos;
	private Position[] predPositions;
	
	public Perception(Position prayPos, Position[] predPositions) {
		this.prayPos = prayPos;
		this.predPositions = predPositions;
	}
}
