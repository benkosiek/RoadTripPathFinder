# 🚗 Java Road Trip Planner (Driver Switch Simulation)

## 📌 Overview

This project is a Java-based **Road Trip Planner** that simulates a multi-leg road trip and automatically inserts **driver switching points** after a certain number of miles.

It’s built using object-oriented and functional design patterns, including recursive linked lists to represent direction steps. The program calculates when the driver should switch based on a user-defined mileage threshold.

---

## 🛠️ How It Works

- A road trip consists of multiple `Directions`, each with a description and number of miles.
- These directions are stored in a custom linked list structure (`ILoDirection`).
- The `splitUpTrip` function inserts **switch commands** (e.g., "Switch with driver2") every `N` miles during the trip.
- The list is split recursively while tracking the number of miles driven.

---

## 🗂️ Class Overview

### `Directions`
- Represents a single direction.
- Fields: `description`, `miles`

### `ILoDirection` (Interface)
- Defines list behavior:
  - `miles()`: total miles in the list
  - `directions()`: formatted string of all directions
  - `splitUp(...)`: inserts switch instructions after every N miles

### `MtLoDirections`
- Represents an empty list of directions.

### `ConsLoDirections`
- A non-empty list (head and tail).
- Implements direction list logic and handles switch insertion.

### `RoadTrip`
- Holds driver names and a list of directions.
- Method: `splitUpTrip(int switchMiles)` returns a new list with switch points added.

### `Main`
- Contains a simple demo `main()` method with placeholder output.

---

## ✅ Example Use Case

1. You have a road trip from NJ to CA.
2. You divide the trip into legs (e.g., "Drive on I-80" for 200 miles, "Take exit 5" for 50 miles, etc.).
3. You want to switch drivers every 300 miles.
4. The program automatically inserts `"Switch with driver2"` after the first 300 miles, then `"Switch with driver1"` after the next 300, and so on.

---

## 🧪 How to Run

### Requirements:
- Java 8+
- [tester.Tester](https://cs111.ccs.neu.edu/home.html) library if using unit tests (not included here)

### Compile:
```bash
javac Main.java
