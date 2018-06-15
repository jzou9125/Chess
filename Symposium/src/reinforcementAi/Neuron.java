package reinforcementAi;

import java.io.Serializable;

public class Neuron implements Serializable{

	private int[] inputs;
	private Neuron[] output;
	private double bias;
	private double weightedSum;
	private double weight;
	private double threshold;
	
	public Neuron(int[] inputs, double threshold) {
		bias = (Math.random()*2) -1;
		weight = (Math.random()*2) -1;
		this.inputs = inputs;
	}
	
	
	public double activationFunction()
	{
		for(int i: inputs)
		{
			weightedSum += (i*weight); 
		}
		weightedSum += bias;
		return weightedSum;
		
	}
	
	public void addInputs(int[] values)
	{
		inputs = values;
	}

	public void setInputs(int[] inputs) {
		this.inputs = inputs;
	}
	
	public void setOutput(Neuron[] output) {
		this.output = output;
	}

}
