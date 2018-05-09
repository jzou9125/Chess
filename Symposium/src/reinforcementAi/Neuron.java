package reinforcementAi;

public class Neuron {

	private Neuron[] network;
	private int[] inputs;
	private double bias;
	private double weightedSum;
	private double weight;
	private double threshold;
	
	public Neuron() {
		bias = (Math.random()*2) -1;
		weight = (Math.random()*2) -1;
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
	
	public void removeConnection(int idx)
	{
		network[idx] = null;
	}

}
