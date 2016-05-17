package pursuitDomain;

public class RandomAdHocProblem extends Problem{

	
	public RandomAdHocProblem(long seed, int numEnvironmentRuns) {
		super(numEnvironmentRuns);
		environment = new Environment(environmentSize, maxIterations, probPreyRests, numPredators, seed);
	}

	@Override
	public void run() {
		environment.simulate();
		
	}
}
