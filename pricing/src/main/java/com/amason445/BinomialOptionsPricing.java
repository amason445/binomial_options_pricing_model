package com.amason445;

public class BinomialOptionsPricing 
{
    public static void main( String[] args )
    {
        // ticker resource file
        TickerManager tsla = new TickerManager("tsla");
        tsla.fillProperties();

        // Parameters
        int N = 1000; // Number of steps
        double S0 = tsla.getSpotPrice(); // Initial stock price
        double K = tsla.getStrikePrice(); // Strike price
        double r = 0.05; // Risk-free rate
        double sigma = tsla.getSigma(); // Volatility
        double T = 1.0; // Time to maturity in years

        // Create an instances of options prices
        AmericanCallOption callPricer = new AmericanCallOption(N, S0, K, r, sigma, T);
        AmericanPutOption  putPricer =  new AmericanPutOption(N, S0, K, r, sigma, T);
        EuropeanCallOption euroCallPricer = new EuropeanCallOption(N, S0, K, r, sigma, T);
        EuropeanPutOption euroPutPricer = new EuropeanPutOption(N, S0, K, r, sigma, T);

        // Calculate the option price
        double callOptionPrice = callPricer.calculateOptionPremium();
        double putOptionPrice = putPricer.calculateOptionPremium();
        double euroCallOptionPrice  = euroCallPricer.calculateOptionPremium();
        double euroPutOptionPrice = euroPutPricer.calculateOptionPremium();

        // Output the result
        System.out.println("The price of the American call option is: " + callOptionPrice);
        System.out.println("The price of the American put option is: " + putOptionPrice);
        System.out.println("The price of the European call option is: " + euroCallOptionPrice);
        System.out.println("The price of the European put option is: " + euroPutOptionPrice);
    }
}
