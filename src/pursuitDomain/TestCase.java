package pursuitDomain;

public class TestCase {
	
	private static final TestCase instance = new TestCase();
	private int testCase;
	private static final int RANDOM_CONTROLLER = 1;
	private static final int ADHOC_CONTROLLER = 2;
	private static final int HOMOGEN_CONTROLLER = 3;
	private static final int HETEROGEN_CONTROLLER = 4;
	
	public TestCase() {
		
	}
	public int getTestCase(){
		return testCase;
	}
	
	public void setTestCase(int t){
		testCase = t;
	}
	public static TestCase getInstace(){
		return instance;
	}
}
