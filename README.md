# married-couples-problem // Probability and Statistics Concurrent programming project

## **Java AWT app to show widely known statistics problem called: ***''Married couples/Dancing partners'' problem*****

### Backstory - The Question

``What is the probability that by generating dancing couples we will get at least one couple that is also a married couple?``

### Realisation

The app is simple GUI project made in Java to show an answer to the previous question.

The idea was to allow User to ***generate n different Dancing partners concurrently***, in order to make program as fast as possible.

The core of the program lays in Java's wide pallete of concurrent programming libraries, as well as a reliable random number generation library. The User is allowed to choose between 3 different libraries in order to generate couples:
- Math.Random, considered the standard random number generator
- util.Random, which ...
- util.concurrent.ThreadLocalRandom, which is the best random number generator in concurrent programs

### How to use the program

Even though the app itself is simple to use, language barrier could occur since the whole app is made in serbian language. Since that's the case, here are the translations and descriptions:
- `Broj ponavljanja == Number of repetitions` : User definies how many threads are going to be generated. Every thread makes exactly one Dancing pair
- `Metoda generisanja == Random number generating method` : User chooses between 3 different generators, previously explained
- `Pokreni simulaciju! == Start simulation!` : :smile:
- `Frekvencija == Frequency` : This textbox shows frequency of good cases. The case is good if any of the dancing pairs is also married
- `Ispocetka? == Again?` : Reset the whole app for new execution
