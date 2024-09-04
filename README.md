# Binomial Options Pricing Model

## Summary

This repository contains a Java application that can calculate options prices using the [Binomial Options Pricing Model](https://en.wikipedia.org/wiki/Binomial_options_pricing_model). The model simulates pricing by filling an NxN matrix instead of the typical "tree" by compounding the spot price to a future price with DeltaT (N steps/T years until maturity), upswing and downswing values. Then, the script performs [backwards induction](https://en.wikipedia.org/wiki/Backward_induction) to arrive at a present value.

In these models, the present value is calculated using a binomial value where "p" is a risk neutral calculated using the risk free rate, the upswing and downswing values. This process is similar to calculating a weighted average of the prior two nodes with p and (1-p). Once this is complete, this average is then discounted and, eventually, the final node selected is (0,0) which contains the fair value of the option today.

There are also class modules for [American and European](https://www.investopedia.com/articles/optioninvestor/08/american-european-options.asp) put contracts. To allow for an American style exercise, as the script progresses through the backwards induction, another check is made for the calls and puts by taking the maximum of the exercise or the hold value. Unlike European style exercises, American options can be exercised early so this must be accounted for throughout the duration of the contract.

## Results
- At the Money Call (Spot: $100, Strike: $100):
  
![alt text](https://github.com/amason445/binomial_options_pricing_model/blob/main/at%20the%20money.png)
- Out of the Money Call (Spot: $100, Strike: $120):
  
![alt text](https://github.com/amason445/binomial_options_pricing_model/blob/main/in%20the%20money.png)
- In of the Money Call (Spot: $100, Strike: $80):

![alt text](https://github.com/amason445/binomial_options_pricing_model/blob/main/out%20of%20the%20money.png)

## Future Ideas
- User interface (CLI/Config File)
- Package application with an interface or class inheritance model
- Add Black Scholes - Merton Model
- Exotic options (asian, bermudan)
- More robust output and visualizations
- Testing against live options chains

## References
- https://www.investopedia.com/terms/b/binomialoptionpricing.asp
- https://en.wikipedia.org/wiki/Binomial_options_pricing_model
- https://en.wikipedia.org/wiki/Backward_induction
- https://www.investopedia.com/articles/optioninvestor/08/american-european-options.asp
 
