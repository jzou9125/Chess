package reinforcementAi;

import java.io.Serializable;

public class Neuron implements Serializable{

	private double[] inputs;
	private Neuron[] output;
	private double bias;
	private double weightedSum = 0;
	private double weight;
	private double threshold = 0;
	
	public Neuron(double[] inputs) {
		bias = (Math.random()*2) -1;
		weight = (Math.random()*2) -1;
		this.inputs = inputs;
		calcInputs();
		
	}
	
	public Neuron(int input) {
		bias = (Math.random()*2) -1;
		weight = (Math.random()*2)-1;
		inputs[0] = input;
	}

	public double activationFunction() //relu
	{
		if(weightedSum < 0) {
			return 0;
		}
		return weightedSum;
	}
	
	public void calcInputs() {
		for(double i: inputs)
		{
			weightedSum += (i*weight);
		}
		weightedSum += bias;
		weightedSum = activationFunction();
		output();
	}
	
	public void output() {
		if(weightedSum > threshold) {
			for(int i =0; i< output.length; i++) {
				output[i].addInputs(weightedSum);
			}
		}
	}
	public void addInputs(double value)
	{
		double[] holder = new double[inputs.length + 1];
		int currentIdx = 0;
		for(double e: inputs) {
			holder[currentIdx] = e;
			currentIdx ++;
		}
		holder[currentIdx] = value;
		inputs = holder; 
		calcInputs();
	}

	public void setInputs(double[] inputs) {
		this.inputs = inputs;
		calcInputs();
	}
	
	public void setOutput(Neuron[] output) {
		this.output = output;
	}

}
