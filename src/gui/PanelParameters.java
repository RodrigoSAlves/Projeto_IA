package gui;

import ga.geneticOperators.MutationMUTATION_NAME;
import ga.geneticOperators.Recombination;
import ga.geneticOperators.RecombinationOneCut;
import ga.geneticOperators.RecombinationTwoCuts;
import ga.geneticOperators.RecombinationUniform;
import ga.selectionMethods.SelectionMethod;
import ga.selectionMethods.Tournament;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import pursuitDomain.PredatorIndividual;
import pursuitDomain.GAPursuitDomainProblem;

public class PanelParameters extends PanelAtributesValue {

    public static final int TEXT_FIELD_LENGHT = 7;
    public static final String SEED = "1";
    public static final String POPULATION_SIZE = "100";
    public static final String GENERATIONS = "100";
    public static final String TOURNAMENT_SIZE = "2";
    public static final String PROB_RECOMBINATION = "0.7";
    public static final String PROB_MUTATION = "0.1";
    JTextField jTextFieldSeed = new JTextField(SEED, TEXT_FIELD_LENGHT);
    JTextField jTextFieldN = new JTextField(POPULATION_SIZE, TEXT_FIELD_LENGHT);
    JTextField jTextFieldGenerations = new JTextField(GENERATIONS, TEXT_FIELD_LENGHT);
    String[] selectionMethods = {"Tournament"};
    String[] selectionControler = {"No Selection", "Random", "AdHoc", "Homegen", "Heterogen"};
    JComboBox jComboBoxSelectionMethods = new JComboBox(selectionMethods);
    JComboBox jComboBoxSelectionControllers = new JComboBox(selectionControler);
    JTextField jTextFieldTournamentSize = new JTextField(TOURNAMENT_SIZE, TEXT_FIELD_LENGHT);
    String[] recombinationMethods = {"One cut", "Two cuts", "Uniform"};
    JComboBox jComboBoxRecombinationMethods = new JComboBox(recombinationMethods);
    JTextField jTextFieldProbRecombination = new JTextField(PROB_RECOMBINATION, TEXT_FIELD_LENGHT);
    JTextField jTextFieldProbMutation = new JTextField(PROB_MUTATION, TEXT_FIELD_LENGHT);
    int testCase;
    //MORE PARAMETERS?
    
    public PanelParameters() {
        title = "Genetic algorithm parameters";
        
        labels.add(new JLabel("Test Controler: "));
        valueComponents.add(jComboBoxSelectionControllers);
        jComboBoxSelectionControllers.addActionListener(new JComboxSelectionControllers_ActionAdapter(this));

        
        
        //MORE PARAMETERS?
        
        configure();
    }
    

    public void actionPerformedSelectionMethods(ActionEvent e) {
        jTextFieldTournamentSize.setEnabled(jComboBoxSelectionMethods.getSelectedIndex() == 0);
    }

    public SelectionMethod<PredatorIndividual, GAPursuitDomainProblem> getSelectionMethod() {
        switch (jComboBoxSelectionMethods.getSelectedIndex()) {
            case 0:
                return new Tournament<>(
                        Integer.parseInt(jTextFieldN.getText()),
                        Integer.parseInt(jTextFieldTournamentSize.getText()));
        }
        return null;
    }

    public Recombination<PredatorIndividual> getRecombinationMethod() {

        double recombinationProb = Double.parseDouble(jTextFieldProbRecombination.getText());

        switch (jComboBoxRecombinationMethods.getSelectedIndex()) {
            case 0:
                return new RecombinationOneCut<>(recombinationProb);
            case 1:
                return new RecombinationTwoCuts<>(recombinationProb);
            case 2:
                return new RecombinationUniform<>(recombinationProb);
        }
        return null;
    }

    public MutationMUTATION_NAME<PredatorIndividual> getMutationMethod() {
        double mutationProbability = Double.parseDouble(jTextFieldProbMutation.getText());
        //COMPLETE?
        return new MutationMUTATION_NAME<>(mutationProbability/*COMPLETE?*/);
    }
    
    public void updateComponentsBasedOnTestCase(){
    	int index = jComboBoxSelectionControllers.getSelectedIndex();
    	
    	switch(index){
    	case (0):{
    		setComponentsNoSolution();
    	}break;
    	case (1):{
    		
    		setComponentsForRandomAdHocSolution(index);
    		
    		testCase = index;
    	}break;
    	
    	case (2):{
    		setComponentsForRandomAdHocSolution(index);
    		testCase = index;
    	}break;
    	case (3):{
    		
    	}break;
    	case (4):{
    		
    	}break;
    	}
    }
    
    public void setComponentsForRandomAdHocSolution(int index){
    	
    	
    	labels.add(new JLabel("Seed: "));
        valueComponents.add(jTextFieldSeed);
        jTextFieldSeed.addKeyListener(new IntegerTextField_KeyAdapter(null));

        labels.add(new JLabel("Population size: "));
        valueComponents.add(jTextFieldN);
        jTextFieldN.addKeyListener(new IntegerTextField_KeyAdapter(null));

        labels.add(new JLabel("# of generations: "));
        valueComponents.add(jTextFieldGenerations);
        jTextFieldGenerations.addKeyListener(new IntegerTextField_KeyAdapter(null));

        labels.add(new JLabel("Selection method: "));
        valueComponents.add(jComboBoxSelectionMethods);
        jComboBoxSelectionMethods.addActionListener(new JComboBoxSelectionMethods_ActionAdapter(this));

        labels.add(new JLabel("Tournament size: "));
        valueComponents.add(jTextFieldTournamentSize);
        jTextFieldTournamentSize.addKeyListener(new IntegerTextField_KeyAdapter(null));

        labels.add(new JLabel("Recombination method: "));
        valueComponents.add(jComboBoxRecombinationMethods);

        labels.add(new JLabel("Recombination prob.: "));
        valueComponents.add(jTextFieldProbRecombination);

        labels.add(new JLabel("Mutation prob.: "));
        valueComponents.add(jTextFieldProbMutation);

    	jTextFieldSeed.setEnabled(index != 0);
    	jTextFieldGenerations.setEnabled(false);
		jTextFieldProbRecombination.setEnabled(false);
		jTextFieldTournamentSize.setEnabled(false);
		jComboBoxSelectionMethods.setEnabled(false);
		jComboBoxRecombinationMethods.setEnabled(false);
		jTextFieldN.setEnabled(false);
		jTextFieldProbMutation.setEnabled(false);
		
		
		
    }
    public void setComponentsNoSolution(){
    	jTextFieldSeed.setEnabled(false);
    	setComponentsForRandomAdHocSolution(0);
    }
	public void actionPerformedSelectionController(ActionEvent e) {
		updateComponentsBasedOnTestCase();
	}
}

class JComboBoxSelectionMethods_ActionAdapter implements ActionListener {

    final private PanelParameters adaptee;

    JComboBoxSelectionMethods_ActionAdapter(PanelParameters adaptee) {
        this.adaptee = adaptee;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        adaptee.actionPerformedSelectionMethods(e);
    }
}

class JComboxSelectionControllers_ActionAdapter implements ActionListener {
	final private PanelParameters adaptee;
	
	JComboxSelectionControllers_ActionAdapter(PanelParameters adaptee) {
		this.adaptee = adaptee;
		adaptee.updateComponentsBasedOnTestCase();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		adaptee.actionPerformedSelectionController(e);		
	}
	
}

class IntegerTextField_KeyAdapter implements KeyListener {

    final private MainFrame adaptee;

    IntegerTextField_KeyAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (!Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
            e.consume();
        }
    }
   
}

/*
 * labels.add(new JLabel("Seed: "));
        valueComponents.add(jTextFieldSeed);
        jTextFieldSeed.addKeyListener(new IntegerTextField_KeyAdapter(null));

        labels.add(new JLabel("Population size: "));
        valueComponents.add(jTextFieldN);
        jTextFieldN.addKeyListener(new IntegerTextField_KeyAdapter(null));

        labels.add(new JLabel("# of generations: "));
        valueComponents.add(jTextFieldGenerations);
        jTextFieldGenerations.addKeyListener(new IntegerTextField_KeyAdapter(null));

        labels.add(new JLabel("Selection method: "));
        valueComponents.add(jComboBoxSelectionMethods);
        jComboBoxSelectionMethods.addActionListener(new JComboBoxSelectionMethods_ActionAdapter(this));

        labels.add(new JLabel("Tournament size: "));
        valueComponents.add(jTextFieldTournamentSize);
        jTextFieldTournamentSize.addKeyListener(new IntegerTextField_KeyAdapter(null));

        labels.add(new JLabel("Recombination method: "));
        valueComponents.add(jComboBoxRecombinationMethods);

        labels.add(new JLabel("Recombination prob.: "));
        valueComponents.add(jTextFieldProbRecombination);

        labels.add(new JLabel("Mutation prob.: "));
        valueComponents.add(jTextFieldProbMutation);

 */
