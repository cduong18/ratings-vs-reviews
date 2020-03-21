import org.junit.Test;

import static org.junit.Assert.*;

public class RecommendationTester {

    @Test
    public void testAverageRating() {
        double[] ratings = new double[] {4.5,4.3,4.0,2.5,3.7};
        Recommendation tester = new Recommendation(ratings, 50, 2, new double[] {0.0,0.0}, new double[] {5.0,5.0},'R');
        System.out.println(tester.averageRating());
        System.out.println(tester.distance());
        System.out.println(tester.priceRange());


    }
}