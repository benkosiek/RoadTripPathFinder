import tester.Tester;

public class Tests {
}

class ExamplesRoadTrip {
  // Directions for the road trip
  Directions direction1 = new Directions("Make a left at Alberquerque", 13);
  Directions direction2 = new Directions("Make a right at the fork", 2);
  Directions direction3 = new Directions("Make a left at the next fork", 3);
  Directions direction4 = new Directions("Take the overpass", 45);
  Directions direction5 = new Directions("Destination on left", 12);

  // List of directions
  ILoDirection directionList = new ConsLoDirections(direction1,
    new ConsLoDirections(direction2,
      new ConsLoDirections(direction3,
        new ConsLoDirections(direction4,
          new ConsLoDirections(direction5, new MtLoDirections())))));

  // Road trip with drivers Hazel and Henry
  RoadTrip roadTrip = new RoadTrip("Hazel", "Henry", directionList);

  // TESTS

  boolean testSplitUpTrip15Miles(Tester t) {
    ILoDirection result = roadTrip.splitUpTrip(15);

    return t.checkExpect(result.directions(),
      "Make a left at Alberquerque for 13 miles\n" +
        "Make a right at the fork for 2 miles\n" +
        "Switch with Henry for 0 miles\n" +
        "Make a left at the next fork for 3 miles\n" +
        "Switch with Hazel for 12 miles\n" +
        "Switch with Henry for 15 miles\n" +
        "Switch with Hazel for 15 miles\n" +
        "Take the overpass for 3 miles\n" +
        "Destination on left for 12 miles");
  }

  boolean testSplitUpTrip10Miles(Tester t) {
    ILoDirection result = roadTrip.splitUpTrip(10);

    return t.checkExpect(result.directions(),
      "Make a left at Alberquerque for 10 miles\n" +
        "Switch with Henry for 0 miles\n" +
        "Make a left at Alberquerque for 3 miles\n" +
        "Make a right at the fork for 2 miles\n" +
        "Make a left at the next fork for 3 miles\n" +
        "Switch with Hazel for 2 miles\n" +
        "Take the overpass for 10 miles\n" +
        "Switch with Henry for 0 miles\n" +
        "Take the overpass for 35 miles\n" +
        "Switch with Hazel for 0 miles\n" +
        "Take the overpass for 10 miles\n" +
        "Destination on left for 12 miles");
  }

  boolean testSplitUpTrip20Miles(Tester t) {
    ILoDirection result = roadTrip.splitUpTrip(20);

    return t.checkExpect(result.directions(),
      "Make a left at Alberquerque for 13 miles\n" +
        "Make a right at the fork for 2 miles\n" +
        "Make a left at the next fork for 3 miles\n" +
        "Switch with Henry for 0 miles\n" +
        "Take the overpass for 20 miles\n" +
        "Switch with Hazel for 0 miles\n" +
        "Take the overpass for 25 miles\n" +
        "Switch with Henry for 0 miles\n" +
        "Destination on left for 12 miles");
  }
}
