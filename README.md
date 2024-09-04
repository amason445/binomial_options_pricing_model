# Binomial Options Pricing Model

## Summary

This repository contains a Java Application that can calculate options prices using the [Binomial Options Pricing Model](https://en.wikipedia.org/wiki/Binomial_options_pricing_model). The model simulates pricing by filling an NxN matrix instead of a typical "tree" by compounding the spot price to a future price with Delta T (N steps/T years until maturity) and then performing [backwards induction](https://en.wikipedia.org/wiki/Backward_induction) to arrive at a present value.

There are class modules for [American and European](https://www.investopedia.com/articles/optioninvestor/08/american-european-options.asp) put contracts. To allow for an American style exercise, as the script progresses through the backwards induction, another check is made for the calls and puts by taking the maximum of the exercise or the hold value. Unlike European style exercises, American options can be exercised early so this must be accounted for throughout the duration of the contract.

## Results
![alt text](https://github.com/amason445/binomial_options_pricing_model/blob/main/Screenshot%202024-09-03%20200335.png)

## Future Ideas
- Package script with an interface or class inheritance model
- Black Scholes - Merton Model
- Exotic options (asian, bermudan)
- More robust output and visualizations

## References
- https://www.investopedia.com/terms/b/binomialoptionpricing.asp
- https://en.wikipedia.org/wiki/Binomial_options_pricing_model
- https://en.wikipedia.org/wiki/Backward_induction
- https://www.investopedia.com/articles/optioninvestor/08/american-european-options.asp
 
