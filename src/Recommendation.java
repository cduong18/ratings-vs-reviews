public class Recommendation {

    /**
     * A class that implements a priority queue to act as a recommendation system
     * for restaurants and services
     */

    private double averageRating;
    private double[] ratings;
    private int numRatings;
    private int numReviews;
    private int dollarSigns; // number of dollar signs on yelp
    private String priceRange;
    private double[] startingCoordinates;
    private double[] destinationCoordinates;
    private double distance;
    private boolean forRestaurant = false; // designates whether recommendation is for restaurant or service


    Recommendation(double[] ratings, int numReviews) {
        this.ratings = ratings;
        this.numReviews = numReviews;
        this.numRatings = ratings.length;
    }

    Recommendation(double[] ratings, int numReviews, int dollarSigns, double[] location, double[] destination, char type) {
        if (location.length != 2 || destination.length != 2) {
            throw new IllegalArgumentException("location and destination must each have two elements," +
                    " the first specifying the x coordinate and the second specifying the y coordinate.");
        }
        if (!(type == 'R' || type == 'S')) {
            throw new IllegalArgumentException("Character must be R for restaurant or S for service");
        }
        this.ratings = ratings;
        this.numReviews = numReviews;
        this.numRatings = ratings.length;

        this.dollarSigns = dollarSigns;
        this.startingCoordinates = location;
        this.destinationCoordinates = destination;

        if (type == 'R') {
            this.forRestaurant = true;
        }

    }

    public double[] getRatings() {
        return this.ratings;
    }

    public int getNumRatings() {
        return this.numRatings;
    }

    public int getNumReviews() {
        return this.numReviews;
    }

    public int getDollarSigns() {
        return this.dollarSigns;
    }

    public double[] getStartingCoordinate() {
        return this.startingCoordinates;
    }

    public double[] getDestinationCoordinate() {
        return this.destinationCoordinates;
    }

    public String getType() {
        if (this.forRestaurant) {
            return "This is part of the Restaurant category.";
        }
        return "This is part of the Service category.";

    }

    public double averageRating() {
        int totalRatings = 0;
        for (double rating: this.ratings) {
            totalRatings += rating;
        }
        averageRating = Math.round(totalRatings/this.numRatings * 100) / 100;

        return averageRating;
    }

    public String priceRange() {
        priceRange = new String();
        for (int i = 0; i < this.dollarSigns; i++) {
            priceRange += "$";
        }
        return priceRange;
    }

    public double distance() {
        double x1 = startingCoordinates[0];
        double y1 = startingCoordinates[1];
        double x2 = destinationCoordinates[0];
        double y2 = destinationCoordinates[1];
        distance = (float) Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
        return distance;
    }

    public String toString() {
        
    }

}
