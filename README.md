# married-couples-problem // Probability and Statistics Concurrent programming project

## **Java AWT app to show widely known statistics problem called: ***''Married couples/Dancing partners'' problem*****

### Backstory - The Question

``What is the probability that by generating dancing couples we will get at least one couple that is also a married couple?``

`CASE A` - Any of the Dancing pairs is also married. `CASE A` in statistics notation is `P(A)`, probability of event A.

### Realisation

The app is simple GUI project made in Java to show an answer to the previous question.

The idea was to allow User to ***generate n different Dancing partners concurrently***, in order to make program as fast as possible.

The core of the program lays in Java's wide pallete of concurrent programming libraries, as well as a reliable random number generation library. The User is allowed to choose between 3 different libraries in order to generate couples:
- Math.Random, considered the standard random number generator
- util.Random, which ...
- util.concurrent.ThreadLocalRandom, which is the best random number generator in concurrent programs

### How to use the program

***----------Before reading and using, check the last section called `Attention`----------***

Even though the app itself is simple to use, language barrier could occur since the whole app is made in serbian language. Since that's the case, here are the translations and descriptions:
- `Broj ponavljanja == Number of repetitions` : User definies how many threads are going to be generated. Every thread makes exactly one Dancing pair
- `Metoda generisanja == Random number generating method` : User chooses between 3 different generators, previously explained
- `Pokreni simulaciju! == Start simulation!` : :wink:
- `Frekvencija == Frequency` : This textbox shows relative frequency/probability of `CASE A`, for instance `P(A)`=0.59. The case is good if any of the dancing pairs is also married
- `Ispocetka? == Again?` : Reset the whole app for new execution

The app contains one big textbox that represents every generated Dancing pair, for instance, one of the lines(line x) could look like this: Generated Array x: 2-8 0-5 4-6 3-9 1-7. Let's understand this:
- Numbers are assigned to people so the program can distinguish them
- Initial pairs are: 0-5 1-6 2-7 3-8 4-9
- In this particular example, person 2 is partner of person 8, person 0 with person 5 etc. Dancig pair 0-5 is only married pair, so `CASE A` is good

At the very bottom of the textbox there's a line that shows results of all N generations: `Ispunjenost zahteva == Fullfilment of requiremnts` and N binary digits, 1 for good case and 0 for bad ones. This is the place where we get relative frequency/probability of `CASE A` : numOfOnes/N

### Conclusion

The more the generations, the better the results! Mathematical calculation shows that correct answer to the question is 0.633. The tabel bellow shows my results:

| Number of generations | Result of Math.Random for the given N | Result of util.Random for the given N | Result of util.concurrent.ThreadLocalRandom for the given N |
| --- | --- | --- | --- |
| 10 | 0.7 | 0.7 | 0.3 |
| 100 | 0.5 | 0.74 | 0.66 |
| 1000 | 0.651 | 0.621 | 0.604 |
| 10 000 | 0.6313 | 0.6385 | 0.6294 |
| 100 000 | 0.632 | 0.63542 | 0.63574 |

If you are really interested in this problem, you can try and search for `Hat check problem`, which is reversed version of `Married couples/Dancing partners` problem.

# Future changes

Unfortunately, no changes are planned for this project as it's quite simple in it's core.

# Attention:exclamation:

This app doesn't have any security mechanism to prevent the User from choosing a really big N. Choosing a very big N can possibly make some harm to your device.
