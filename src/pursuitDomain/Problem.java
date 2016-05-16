package pursuitDomain;

public class Problem {

	protected static final int environmentSize = 10;
	protected static final int maxIterations = 20;
	protected static final float probPreyRests = (float) 0.1;
	protected static final double numPredators = 4;
	
	protected Environment environment;
	
	protected final int numEnvironmentRuns;
	
	public Problem(int numEnvironmentRuns) {
		this.numEnvironmentRuns = numEnvironmentRuns;
	}

    
}
