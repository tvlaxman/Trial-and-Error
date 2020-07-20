public class TransitCalculator {

  String[] rideTypes = {"Pay-per-ride" , "7-day Unlimited Ride" , "30-day Unlimited Ride"};

  double[] prices = {2.75 , 33.00, 127.00};
  
  double[] reducedPrices = {1.35 , 16.50 , 63.50};

  double numRides;
  double numDays;
  boolean seniorCitizen;
  boolean disabilities;

  public TransitCalculator(int numRides, int numDays, boolean seniorCitizen, boolean disabilities) {
    
    this.numRides = numRides;
    this.numDays = numDays;
    this.seniorCitizen = seniorCitizen;
    this.disabilities = disabilities;

      }
  
  public double unlimited7Price() {

    double numTickets = Math.ceil(numDays/7.0);
    double totalPrice = numTickets * prices[1]; 
    double pricePerRide = totalPrice / numRides;

    return pricePerRide;
  }

  public double unlimited7ReducedPrice() {

    double numTickets = Math.ceil(numDays/7.0);
    double totalPrice = numTickets * reducedPrices[1]; 
    double reducedPricePerRide = totalPrice / numRides;

    return reducedPricePerRide;
  }

  public double[] getReducedRidePrices() {

    double payPerRideReducedPrice = reducedPrices[0];
    double unlimited7ReducedPrice = unlimited7ReducedPrice();
    double unlimited30ReducedPrice = reducedPrices[2] / numRides;

    double[] reducedPrices = {payPerRideReducedPrice , unlimited7ReducedPrice , unlimited30ReducedPrice};

    return reducedPrices;

  }
     
  public double[] getRidePrices() {

    double payPerRidePrice = prices[0];
    double unlimited7Price = unlimited7Price();
    double unlimited30Price = prices[2] / numRides;

    double[] prices = {payPerRidePrice , unlimited7Price , unlimited30Price};

    return prices; 

  }

  public String getBestFare() {

    if (seniorCitizen  || disabilities) {
      double[] reducedPrices = getReducedRidePrices();
    int finalIndex = 0;

    for (int i = 0 ; i < reducedPrices.length ; i++) {

      if (reducedPrices[i] < reducedPrices[finalIndex]) {
        
        finalIndex = i;

      }
    }

    return "You should get the " + rideTypes[finalIndex] + " option at $" + Math.round(reducedPrices[finalIndex] * 100.0) / 100.0 + " per ride.";
    } 
    
    else {

    double[] prices = getRidePrices();
    int finalIndex = 0;

    for (int i = 0 ; i < prices.length ; i++) {

      if (prices[i] < prices[finalIndex]) {
        
        finalIndex = i;

      }
    }

    return "You should get the " + rideTypes[finalIndex] + " option at $" + Math.round(prices[finalIndex] * 100.0) / 100.0 + " per ride.";

    }
  }

  public static void main(String[] args) {


    TransitCalculator firstFare = new TransitCalculator(12, 5, false, true);

    System.out.println(firstFare.getBestFare());
  }
  
}
