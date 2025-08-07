import tester.Tester;

interface RoadTripChunks{

}

interface ILoDirection {
  int miles();
  String directions();
  ILoDirection splitUp(int switchMiles, String currentDriver, int milesDriven);
}

class MtLoDirections implements ILoDirection {
  MtLoDirections() {}

  public int miles() {
    return 0;
  }

  public String directions() {
    return "";
  }

  public ILoDirection splitUp(int switchMiles, String currentDriver, int milesDriven) {
    // No more directions, return empty list
    return this;
  }
}

class ConsLoDirections implements ILoDirection {
  Directions first;
  ILoDirection rest;

  ConsLoDirections(Directions first, ILoDirection rest) {
    this.first = first;
    this.rest = rest;
  }


  public int miles() {
    return first.miles + rest.miles();
  }

  public String directions() {
    return first.description + " for " + first.miles + " miles\n" + rest.directions();
  }

  public ILoDirection splitUp(int switchMiles, String currentDriver, int milesDriven) {
    if (milesDriven + first.miles > switchMiles) {
      int remainingMiles = switchMiles - milesDriven;
      Directions switchDirection = new Directions("Switch with " + (currentDriver.equals("driver1") ? "driver2" : "driver1"), 0);
      Directions newDirection = new Directions(first.description, first.miles - remainingMiles);

      return new ConsLoDirections(switchDirection, new ConsLoDirections(newDirection, rest.splitUp(switchMiles, currentDriver.equals("driver1") ? "driver2" : "driver1", 0)));
    } else {
      return new ConsLoDirections(first, rest.splitUp(switchMiles, currentDriver, milesDriven + first.miles));
    }
  }
}

class Directions {
  String description;
  int miles;

  Directions(String description, int miles) {
    this.description = description;
    this.miles = miles;
  }
}

class RoadTrip {
  String driver1;
  String driver2;
  ILoDirection direction;

  RoadTrip(String driver1, String driver2, ILoDirection direction) {
    this.driver1 = driver1;
    this.driver2 = driver2;
    this.direction = direction;
  }

  // Split the road trip based on the given switch miles
  ILoDirection splitUpTrip(int switchMiles) {
    return direction.splitUp(switchMiles, driver1, 0);
  }
}



