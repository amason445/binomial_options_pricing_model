package com.amason445;

public class AmericanPutOption {
    private int N; //number of time steps in the model
    private double s0; //spot price of security
    private double K; //strike price of security
    private double r; //risk free interest rate
    private double sigma; //Volatility of security
    private double T; //time in days until maturity

    public AmericanPutOption(int N, double s0, double K, double r, double sigma, double T) {
        this.N = N;
        this.s0 = s0;
        this.K = K;
        this.r = r;
        this.sigma = sigma;
        this.T = T;
    }

    public double calculateOptionPremium() {
        double deltaT = T / N; //timestep interval
        double u = Math.exp(sigma * Math.sqrt(deltaT)); //up movement
        double d = 1 / u; //down movement
        double p = (Math.exp(r * deltaT) - d) / (u - d); //risk neutral probability measure
        double discountFactor = Math.exp(-r * deltaT);

        //2d array to process model
        double[][] option_values = new double[N +1][N +1];

        //initialize stock prices and fill the array
        for (int i = 0; i <= N; i++) {
            double stockPriceAtMaturity = s0  * Math.pow(u, N - i) * Math.pow(d, i);
            option_values[i][N] = Math.max(0, K - stockPriceAtMaturity);
        }

        //backward induction to calculate option value
        for (int j = N - 1; j >= 0; j--) {
            for (int i = 0; i <= j; i++) {
                double stockPriceAtCurrentNode = s0 * Math.pow(u, j - i) * Math.pow(d, i);
                double holdValue = discountFactor * (p * option_values[i][j + 1] + (1 - p) * option_values[i + 1][j + 1]);
                double exerciseValue = Math.max(0, K - stockPriceAtCurrentNode);
                option_values[i][j] = Math.max(holdValue, exerciseValue);
                }
            }

        //price at the root node
        return option_values[0][0]; 
    } 
}
