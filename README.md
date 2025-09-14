# Ride-sharing-System
A simple java  **Ride Sharing System**  with 
- Custom Exception ('InvalidRideTypeException')
- Abstract Classes ('Ride')
- Inheritance and polimorphism ('BikeRide', 'CarRide')
- User Input Handling with 'Scanner'

The system allows a user to book either a **Bike** or a **Car** ride, enter the distace, and get the calculated fare.

---
# Features :
- Enter ride type ('bike' or 'car')
- Enter distance traveled
- Calculate fare:
  - **Bike** = ₹10 * distance
  - **car**  = ₹20 * distance 
- Error handling:
 - Invalid ride Type
 - Invalid distance (<= 0)

---

# Example Run:

##Input 
bike
12

##Output
Driver: Raju
Vehicle No: AP39AB1234
Distance: 12.0 km
Fare: ₹120.0

## How to Run :
 # in Terminal
  1. clone the repo
   ..bash
   gitclone https://github.com/<abhilashbusa-gitacc01>/Ride-Sharing-System.git
   cd Ride-Sharing-System

   javac Ridde-sharing-Syatem.java
   java Ride-Sharing-System

 # Manually
  - open your vscode/byteXL-nimbus or other platforms
  - copy & paste this code
  - click on 'Run'
  - it will compile and run the code if oracle java development kit is installed on your pc
  - now in 'terminal' give input and press 'ctrl+enter'
